package com.Hospital.System;

import java.util.Scanner;

public class Portal {
	static Scanner s = new Scanner(System.in);
	DBHandler db = new DBHandler();

	public static void start() {
		Portal p = new Portal();
		p.login();
	}

	public void login() {
		out: while (true) {
			System.out.println("\n\t\tHospital System" + "\n\t\t1. Admin login" + "\n\t\t2. Doctor login "
					+ "\n\t\t3. Receptionist login");

			switch (s.nextInt()) {
			case 1:
				System.out.println("Enter username : ");
				String username = s.next();

				System.out.println("Enter password : ");
				String password = s.next();

				
				if (db.authenticate("admin", username, password) != -1)
					adminPortal();
				else
					System.out.println("Authentication failed");
				break;

			case 2:
				System.out.println("Enter username : ");
				username = s.next();

				System.out.println("Enter password : ");
				password = s.next();

				int id = db.authenticate("doctor", username, password);
				if (id != -1)
					doctorPortal(id);
				else
					System.out.println("Authentication failed");
				break;

			case 3:
				System.out.println("Enter username : ");
				username = s.next();

				System.out.println("Enter password : ");
				password = s.next();

				id = db.authenticate("receptionist", username, password);
				if (id != -1)
					receptionistPortal(id);
				else
					System.out.println("Authentication failed");
				break;
			case 4:
				break out;
				default : 
					System.out.println("\nInvalid choice\n");
			}
		}
	}

	private void adminPortal() {

		out: while (true) {
			System.out.println("Enter your choice : ");
			System.out.println("1. Create doctor");
			System.out.println("2. Create receptionist");
			System.out.println("3. Create admin");
			System.out.println("4. View doctor");
			System.out.println("5. View receptionist");
			System.out.println("6. View admin");
			System.out.println("7. Exit");

			switch (s.nextInt()) {
			case 1:
				db.createDoctor();
				break;

			case 2:
				db.createReceptionist();
				break;
			case 3:
				db.createAdmin();
				break;
			case 4:
				db.printDoctors();
				break;
			case 5:
				db.printReceptionist();
				break;
			case 6:
				db.printAdmin();
				break;
			case 7:
				break out;
			default:
				System.out.println("Invalid choice. ");
				break;
			}
		}
	}

	private void doctorPortal(int id) {

		out: while (true) {
			System.out.println("Enter your choice : ");
			System.out.println("1. View appointments");
			System.out.println("2. Finish appointments");
			System.out.println("3. Exit");

			switch (s.nextInt()) {
			case 1:
				db.printAppointments(id);
				break;
			case 2:
//				db.finishAppointments(id);
				break;
			case 3:
				break out;
			default:
				System.out.println("Invalid choice");
			}
		}
	}

	private void receptionistPortal(int id) {
		out: while (true) {
			System.out.println("Enter your choice : ");
			System.out.println("1. View all appointments");
			System.out.println("2. Book appointment");
			System.out.println("3. Cancel appointment");
			System.out.println("4. ");
			
			switch (s.nextInt()) {
			case 1:
				db.printAppointments();
				break;
			case 2:
//				db.finishAppointments(id);
				break;
			case 3:
				break out;
			default:
				System.out.println("Invalid choice");
			}
		}
	}
}
