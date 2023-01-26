package com.Hospital.System;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DBHandler {
	static Scanner s = new Scanner(System.in);
	Connection hospital;
	Statement smt;

	DBHandler() {
		try {
			this.hospital = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "1234");
			this.smt = hospital.createStatement();

		} catch (SQLException e) {
			System.out.println("Sothanaigal ... ");
			e.printStackTrace();
		}
	}

	public int authenticate(String tableName, String username, String password) {
		ResultSet res;
		try {
			res = smt.executeQuery("select * from " + tableName + " where username = \"" + username
					+ "\" and password = MD5(\"" + password + "\");");
			if(res.next()) return res.getInt(1);
			return -1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	public void printAppointments() {
		try {
			ResultSet res = smt.executeQuery("select * from appointment;");

			System.out.println("+-----+--------------------+");
			System.out.println("|   ID|                NAME|");
			System.out.println("+-----+--------------------+");
			while (res.next()) {
				System.out.println(String.format("|%5s|%20s|", res.getInt(1), res.getString(2)));
				System.out.println("+-----+--------------------+");
			}
		} catch (SQLException e) {
			System.out.println("Failed to display all data : " + e);
		}

	}

	public void createAdmin() {
		System.out.println("Enter username : ");
		String username = s.next();

		System.out.println("Enter Password : ");
		String password = s.next();

		System.out.println("Enter password again : ");
		if (!password.equals(s.next())) {
			System.out.println("Password mismatch. Account not created.");
			return;
		}
		try {
			smt.executeUpdate("insert into admin(username, password) values('" + username + "', '" + password + "');");
		} catch (SQLException e) {
			System.out.println("Failed account creation : " + e);
		}
	}

	public void printAdmin() {
		try {
			ResultSet res = smt.executeQuery("select id, username from admin;");

			System.out.println("+-----+--------------------+");
			System.out.println("|   ID|                NAME|");
			System.out.println("+-----+--------------------+");
			while (res.next()) {
				System.out.println(String.format("|%5s|%20s|", res.getInt(1), res.getString(2)));
				System.out.println("+-----+--------------------+");
			}
		} catch (SQLException e) {
			System.out.println("Failed to display all data : " + e);
		}
	}

	public void printReceptionist() {
		try {
			ResultSet res = smt.executeQuery("select * from receptionist");

			System.out.println("+--------+--------------------+---------------+");
			System.out.println("|      ID|                NAME|   PHONE NUMBER|");
			System.out.println("+--------+--------------------+---------------+");
			while (res.next()) {
				System.out.println(String.format("|%8s|%20s|%15s|", res.getInt(1), res.getString(2), res.getString(5)));
				System.out.println("+--------+--------------------+---------------+");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void createReceptionist() {
		System.out.print("\n\t\tEnter the receptionist name : ");
		String name = s.next();

		System.out.print("\n\t\tCreate the receptionist username : ");
		String username = s.next();

		System.out.print("\n\t\tCreate password : ");
		String password = s.next();

		System.out.print("\n\t\tRe-enter password : ");

		if (!password.equals(s.next())) {
			System.out.println("Password mismatch. Account not created");
			return;
		}

		System.out.print("\n)\t\tEnter phone number : ");
		String phno;
		try {
			phno = s.nextLong() + "";
		} catch (NumberFormatException e) {
			System.out.println("Invalid phone number. Account not created. ");
			return;
		}

		queryUpdate("insert into receptionist(name, username, password, phno) values(\"" + name + "\",\"" + username
				+ "\", MD5(\"" + password + "\"), \"" + phno + "\");");
		System.out.println("Account created");
	}

	public void createPatient() {
		System.out.print("\n\t\tEnter Patient name : ");
		String name = s.next();

		System.out.print("\n\t\tEnter patient's age : ");
		int age = s.nextInt();

		System.out.print("\n\t\tEnter patient's gender (M/F/O): ");
		String gender = s.next().charAt(0) + "";

		System.out.print("\n\t\tEnter patient's contact number : ");

		try {
			String phno = s.nextLong() + "";

			queryUpdate("insert into patient(name, age, gender, phno) values(\"" + name + "\",\"" + age + "\",\""
					+ gender + "\",\"" + phno + "\");");
		} catch (NumberFormatException e) {
			System.out.println("The phone number you entered is invalid " + e);
		}

	}

	/**
	 * Prints all the patients details in the Database.Patients.
	 * 
	 * @return void
	 */
	public void printPatients() {
		try {
			ResultSet res = smt.executeQuery("Select * from patient");
			System.out.println("+--------+--------------------+--------+--------+");
			System.out.println("|      ID|                NAME|     AGE|     SEX|");
			System.out.println("+--------+--------------------+--------+--------+");

			while (res.next()) {
				System.out.println(String.format("|%8s|%20s|%8s|%8s|", res.getInt(1), res.getString(2), res.getInt(3),
						res.getString(4)));
				System.out.println("+--------+--------------------+--------+--------+");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void printDoctors() {
		try {
			ResultSet res = smt.executeQuery("select * from doctor");

			System.out.println("+--------+--------------------+--------------------+");
			System.out.println("|      ID|                NAME|      SPECIALIZATION|");
			System.out.println("+--------+--------------------+--------------------+");

			while (res.next()) {
				System.out.println(String.format("|%8s|%20s|%20s|", res.getInt(1), res.getString(2), res.getString(5)));
				System.out.println("+--------+--------------------+--------------------+");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void createDoctor() {
		try {
			System.out.println("Enter the doctor name : ");
			String docname = s.next();
			System.out.println();

			System.out.println("Create the doctor's username : ");
			String docUserName = s.next();
			System.out.println();

			System.out.println("Create password : ");
			String password = s.next();
			System.out.println("Re-enter password : ");

			if (!password.equals(s.next())) {
				System.out.println("Password mismatch. Account not created");
				return;
			}

			System.out.println("Doctor specialization : ");
			String special = s.next();
			System.out.println();

			queryUpdate("insert into doctor(name, username, password, specialization) values(\"" + docname + "\",\""
					+ docUserName + "\", MD5(\"" + password + "\"),\"" + special + "\");");
			System.out.println("Account created");

		} catch (Exception e) {
			System.out.println("Sothanaigal ... " + e);
		}
	}

	public void queryUpdate(String command) {
		try {
			smt.executeUpdate(command);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void printAppointments(int id) {
		// TODO Auto-generated method stub

	}
}