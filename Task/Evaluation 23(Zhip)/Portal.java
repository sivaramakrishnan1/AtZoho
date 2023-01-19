package Zhip;

import Zhip.user.User;
import java.util.*;
import java.io.*;

public class Portal implements Serializable
{
	static HashMap<String, User> users = new HashMap<>();
	static Scanner s = new Scanner(System.in);
	static final long serialVersionUID = 904779;
	
	@SuppressWarnings("unchecked")
	public static void serialize() 
	{
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Zhip/DB.txt"));
			oos.writeObject(users);
			oos.close();
		} catch(Exception e) {
			System.out.println("Error vanthuchu : writing : " + e);
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void deserialize()
	{
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Zhip/DB.txt"));
			users = (HashMap<String, User>) ois.readObject();
			ois.close();
		} catch(Exception e) {
			System.out.println("Error vanthuchu : reading : " + e);
		}
	}
	
	public static void portal() throws Exception 
	{
		deserialize();
		Portal port = new Portal();
		
		out : while(true) {
			port.clear();
			System.out.println("\t\t# - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - #");
			System.out.println("\t\t|                            Zhip                             |");
			System.out.println("\t\t|                     build(friendship)                       |");
			System.out.println("\t\t# - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - #");
			
			System.out.print("What's on your mind ? \n\t\t1. Log-in \n\t\t2. Sign-up\n\t\t3. Exit\n\nYour choice : ");
			switch(s.nextInt())
			{
				case 1 : 
					Console c = System.console();
					port.clear();
					System.out.println("Enter username : ");
					String username = s.next();
					System.out.println("Enter password : ");
					String password = String.valueOf(c.readPassword());
					
					if(!users.containsKey(username))
					{
						for(int i = 5 ; i > 0 ; i--)
						{
							port.clear();
							System.out.println("Hmm .. We can't find a account with that username. \nIf you like to join us, sign up ?");
							System.out.print("\n\nExiting in ..");
							System.out.print(i + " ");
							Thread.sleep(1000);
						}
						break;
					}
					
					if(users.get(username).authenticate(password))
						port.login(username);
					else
					{						
						for(int i = 5 ; i > 0 ; i--)
						{
							port.clear();
							System.out.println("That password is not matching with the username you entered :-(");
							System.out.print("\n\nExiting in ..");
							System.out.print(i + " ");
							Thread.sleep(1000);
						}
						break;
					}
					break;
				
				case 2 : 
					port.clear();
					System.out.println("\t\t# - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - #");
					System.out.println("\t\t|                            Zhip                             |");
					System.out.println("\t\t|                   Making ourselves better                   |");
					System.out.println("\t\t# - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - #");
					
					System.out.print("\n\nEnter your first name : ");
					String fname = s.next();
					System.out.print("\n\nEnter your last name : ");
					String lname = s.next();
					System.out.print("\n\nEnter username : ");
					String uname = s.next();
					
					if(users.containsKey(uname))
					{
						
						for(int i = 5 ; i > 0 ; i--)
						{
							port.clear();
							System.out.print("\n\nUsername already taken try another username\n\nExiting in...");
							System.out.print("\n\nExiting in ..");
							System.out.print(i + " ");
							Thread.sleep(1000);
						}
						break;
					}
					c = System.console();
					
					// encpassword, email, phno
					System.out.print("\nEnter Password : ");
					password = String.valueOf(c.readPassword());
					
					System.out.print("\nEnter Password again : ");
					if(!password.equals(String.valueOf(c.readPassword())))
					{
						for(int i = 5 ; i > 0 ; i--)
						{
							port.clear();
							System.out.println("Password Mismatch");
							System.out.print("\n\nExiting in ..");
							System.out.print(i + " ");
							Thread.sleep(1000);
						}
						break;
					}
					
					System.out.print("\nEnter your mailid : ");
					String email = s.next();
					System.out.print("\nEnter your phone number without country code : ");
					String phno = s.next();
					System.out.print("\nEnter your age : ");
					int age = s.nextInt();
					
					// public User (String username, String firstname, String lastname, String password, String email, int age, String phno) 

					users.put(uname, new User(uname, fname, lname, password, email, age, phno));
					String str = users.get(uname).toString();
					
					for(int i = 5 ; i > 0 ; i--)
					{
						port.clear();
						System.out.println("Account created for : \n" + str);
						
						System.out.print("\n\nExiting in ..");
						System.out.print(i + " ");
						Thread.sleep(1000);
					}
					break;

				
				case 3 : 
					break out;
				
				default : 
					for(int i = 5 ; i > 0 ; i--)
					{
						port.clear();
						System.out.println("Innoru chance kodukuren ... correct number input kodunga");
						System.out.print("\n\nExiting in ..");
						System.out.print(i + " ");
						Thread.sleep(1000);
					}
					break;
			}
		}
		serialize();
	}
	
	public void login(String username) throws Exception
	{
		out : while(true) {
			clear();
			System.out.println("\t\t# - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - #");
			System.out.println("\t\t|                            Zhip                             |");
			System.out.println("\t\t|                       (Welcome back)                        |");
			System.out.println("\t\t# - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - #");
			
			System.out.print("What's on your mind ? " +
			"\n\n\t1. Send friend request " + 
			"\n\n\t2. Show friends list" + 
			"\n\n\t3. Show pending requests" + 
			"\n\n\t4. Remove friends " + 
			"\n\n\t5. Search " + 
			"\n\n\t6. View Profile " + 
			"\n\n\t7. Logout " 
			);
			switch(s.nextInt())
			{
				case 1 : 
				clear();
				System.out.println("\t\t- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
				System.out.println("\t\t|        Enter username to send friend request              |");
				System.out.println("\t\t- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");

				String req = s.next();
				
				if(!users.containsKey(req))
				{
					for(int i = 5 ; i > 0 ; i--)
					{
						clear();
						System.out.println("\t\t- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
						System.out.println("\t\t                   No such username found                     ");
						System.out.println("\t\t- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
						System.out.print("\n\nExiting in ..");
						System.out.print(i + " ");
						Thread.sleep(1000);
					}
					break;
					
				}
				
				users.get(req).friendReq.add(users.get(username));
				for(int i = 5 ; i > 0 ; i--)
					{
						clear();
						System.out.println("\t\t- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
						System.out.println("\t\t                  Friend Request sent                         ");
						System.out.println("\t\t- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
						System.out.print("\n\nExiting in ..");
						System.out.print(i + " ");
						Thread.sleep(1000);
					}
				break;

				case 2:
				clear();
				users.get(username).printFriends();
				System.out.println("\n\n\t\tPress enter to continue : ");
				s.nextLine();
				s.nextLine();
				break;
				
				case 3:
				clear();
				users.get(username).printRequests();
				System.out.println("\n\n\t\tPress enter to continue : ");
				s.nextLine();
				s.nextLine();
				break;
				
				case 4:
				clear();
				System.out.println("\t\t- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
				System.out.println("\t\t|      Enter username to remove from your friend list       |");
				System.out.println("\t\t- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");

				req = s.next();
				clear();
				users.get(username).removeFriend(s.next());
				System.out.println("\n\n\t\tPress enter to continue : ");
				s.nextLine();
				s.nextLine();
				
				break;
				
				case 5:
				clear();
				System.out.println("\t\t- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
				System.out.println("\t\t|                 Enter username to search                  |");
				System.out.println("\t\t- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");

				req = s.next();
				
				if(!users.containsKey(req))
				{
					for(int i = 5 ; i > 0 ; i--)
					{
						clear();
						System.out.println("\t\t- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
						System.out.println("\t\t                   No such username found                     ");
						System.out.println("\t\t- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
						System.out.print("\n\nExiting in ..");
						System.out.print(i + " ");
						Thread.sleep(1000);
					}
					break;
				}
				System.out.println(users.get(req).toString() + "\n\nPress enter to exit : ");
				s.nextLine();
				s.nextLine();
				break;
				
				case 6:
				clear();
				System.out.println(users.get(username).toString() + "\n\nPress enter to exit : ");
				s.nextLine();
				s.nextLine();
				break;
				
				case 7 : 
					break out;
				default : 
					for(int i = 5 ; i > 0 ; i--)
					{
						clear();
						System.out.println("Innoru chance kodukuren ... correct number input kodunga");
						System.out.print("\n\nExiting in ..");
						System.out.print(i + " ");
						Thread.sleep(1000);
					}
					break;
			}
		}
	}
	
	public void clear() throws IOException, InterruptedException
	{
		// for(int i = 0 ; i < 60 ; i++)
			// System.out.println();
		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	}
}