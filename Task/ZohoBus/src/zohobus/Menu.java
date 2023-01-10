package zohobus;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import zohobus.accounts.Admin;
import zohobus.accounts.User;

public class Menu implements Serializable {

	private static final long serialVersionUID = 9047799447L;
	private static List<User> users = new ArrayList<>();
	private static List<Admin> admins = new ArrayList<>();
	private static List<Agency> agencies = new ArrayList<>();

	Scanner s = new Scanner(System.in);

	/*
	 * users.add(new User("Siva", "Siva101")); admins.add(new Admin("Avis",
	 * "Avis101")); agencies.add(new Agency("Rama", "Amar"));
	 */

	public static void login() {
		Scanner s = new Scanner(System.in);
		Menu m = new Menu();
		m.deserialize();

		loop: while (true) {
			System.out.println("\n\n\t\tZoho Bus Log-in" + "\nSelect one from the option" + "\n1. User login"
					+ "\n2. Travel Agency login" + "\n3. Admin login" + "\n4. Exit");

			switch (s.nextInt()) {
			case 1:
				System.out.println("Enter your username: ");
				String username = s.next();

				System.out.println("Enter your password: ");
				String password = s.next();

				for (int i = 0; i < users.size(); i++) {
					if (users.get(i).getUsername().equals(username) && users.get(i).authenticate(password)) {
						m.userLogin(users.get(i));
						break;
					} else if (users.get(i).getUsername().equals(username)) {
						System.out.println("The password you entered is not matching with the username you entered");
						break;
					}
				}
				break;

			case 2:
				System.out.println("Enter your username: ");
				username = s.next();

				System.out.println("Enter your password: ");
				password = s.next();

				for (int i = 0; i < admins.size(); i++) {
					if (admins.get(i).getUsername().equals(username) && admins.get(i).authenticate(password)) {
						m.adminLogin(i);
						break;
					} else if (admins.get(i).getUsername().equals(username)) {
						System.out.println("The username/password you entered is not matching");
						break;
					}
				}
				break;

			case 3:
				System.out.println("Enter your username: ");
				username = s.next();

				System.out.println("Enter your password: ");
				password = s.next();

				for (int i = 0; i < agencies.size(); i++) {
					if (agencies.get(i).getUsername().equals(username) && agencies.get(i).authenticate(password)) {
						m.agencyLogin(agencies.get(i));
						break;
					} else if (agencies.get(i).getUsername().equals(username)) {
						System.out.println("The username/password you entered is not matching");
						break;
					}
				}
				break;

			case 4:
				break loop;

			default:
				System.out.println("Invalid choice");
				break;
			}
		}
		m.serialize();
	}

	public void userLogin(User u) {
		int choice;

		loop: while (true) {
			System.out.println(
					String.format("\n%-20s\n%-20s\n%-20s", "1. Book ticket", "2. Cancel Ticket", "3. View Ticket"));

			choice = s.nextInt();
			switch (choice) {
			case 1: {
				bookTicket(u);
				break;
			}

			case 4: {
				break loop;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + choice);
			}
		}
	}

	private void bookTicket(User u) {
		int index = 0;
		HashMap<Integer, int[]> map = new HashMap<>();
		System.out.println("Enter From location : ");
		String from = (s.next()).toUpperCase();

		System.out.println("Enter destination location : ");
		String to = (s.next()).toUpperCase();

		for (int i = 0; i < agencies.size(); i++) {
			for (int j = 0; j < agencies.get(i).busses.size(); j++) {
				if (agencies.get(i).busses.get(j).isOnTheWay(from) != -1
						&& agencies.get(i).busses.get(j).isOnTheWay(to) != -1) {
					map.put(++index, new int[] { i, j });
					System.out.println(agencies.get(i).busses.get(j).toString());
				}
			}
		}

		System.out.println("\n\nSelect a travel agency : (Enter -1 to exit) ");
		int choice = s.nextInt();
		if (choice == -1)
			return;

		agencies.get(map.get(choice)[0]).busses.get(map.get(choice)[1]).printSeats();
		System.out.println("\n\nSelect seat : (Enter -1 to exit) ");
		int seatchoice = s.nextInt();
		if (seatchoice == -1)
			return;

		System.out.println("\n\nEnter date :");
		String date = s.next();
		agencies.get(map.get(choice)[0]).busses.get(map.get(choice)[1]).bookSeat(seatchoice, from, to, date, u);

	}

	private void agencyLogin(Agency a) {
		int choice = 0;

		loop: while (true) {
			System.out.println("\n\t1. Add bus\n\t4. Exit");
			choice = s.nextInt();

			switch (choice) {
			case 1: {
				addBus(a);
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + choice);
			}
		}
	}

	private void adminLogin(int i) {
		// TODO Auto-generated method stub

	}

	public boolean addBus(Agency a) {
		System.out.println("Enter bus name: ");
		String name = s.nextLine();
		System.out.println("Enter bus seat capacity");
		int capacity = s.nextInt();

		System.out.println("Enter the number of stops: ");
		int stopCount = s.nextInt();

		String stops[] = new String[stopCount];
		float fares[] = new float[stopCount - 1];

		for (int i = 0; i < stopCount; i++) {
			System.out.println("Enter a stop name : ");
			stops[i] = s.next();
			if (i != stopCount - 1) {
				System.out.println("Enter the fare to travel from this to next stop : ");
				fares[i] = s.nextFloat();
			}
		}
		return true;
	}

	public boolean validatePassword(String password) {
		String[] patterns = { "[A-Za-z0-9]*[a-z][A-Za-z0-9]*", "[A-Za-z0-9]*[A-Z][A-Za-z0-9]*",
				"[A-Za-z0-9]*[0-9][A-Za-z0-9]*", ".{6,}" };
		for (int i = 0; i < patterns.length; i++) {
			Pattern p = Pattern.compile(patterns[i]);
			Matcher m = p.matcher(password);
			if (!m.find()) {
				System.out.println(
						"Password must contain and uppercase, lowercase and numerical character and should be more than 6 charcters");
				return false;
			}
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public void deserialize() {
		ObjectInputStream reader;
		try {
			reader = new ObjectInputStream(new FileInputStream("src/zohobus/db/users.tmp"));
			users = (List<User>) reader.readObject();
			reader.close();

			reader = new ObjectInputStream(new FileInputStream("src/zohobus/db/admins.tmp"));
			admins = (List<Admin>) reader.readObject();
			reader.close();

			reader = new ObjectInputStream(new FileInputStream("src/zohobus/db/agencies.tmp"));
			agencies = (List<Agency>) reader.readObject();
			reader.close();

		} catch (Exception e) {
			System.out.println("Nee thottadhu pooramey error than! : " + e);
		}
	}

	public void serialize() {
		ObjectOutputStream writer;
		try {
			writer = new ObjectOutputStream(new FileOutputStream("src/zohobus/db/users.tmp"));
			writer.writeObject(users);
			writer.close();
			writer = new ObjectOutputStream(new FileOutputStream("src/zohobus/db/admins.tmp"));
			writer.writeObject(admins);
			writer.close();
			writer = new ObjectOutputStream(new FileOutputStream("src/zohobus/db/agencies.tmp"));
			writer.writeObject(agencies);
			writer.close();

		} catch (Exception e) {
			System.out.println("Nee thottadhu pooramey error than! : " + e);
		}
	}

}
