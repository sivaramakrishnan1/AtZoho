package com.Hospital.System;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBHandler {

	Connection hospital;

	DBHandler() {
		try {
			this.hospital = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "1234");
		} catch (SQLException e) {
			System.out.println("Sothanaigal ... ");
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		DBHandler db = new DBHandler();
		db.printPatients();
	}

	/**
	 * Prints all the patients details in the Database.Patients.
	 * 
	 * @return void
	 */
	public void printPatients() {
		try {
			Statement smt = hospital.createStatement();
			ResultSet res = smt.executeQuery("Select * from patient");
			System.out.println("+~~~~~~~~+~~~~~~~~~~~~~~~~~~~~+~~~~~~~~+~~~~~~~~+");
			System.out.println("|      ID|                NAME|     AGE|     SEX|");
			System.out.println("+~~~~~~~~+~~~~~~~~~~~~~~~~~~~~+~~~~~~~~+~~~~~~~~+");

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
			Statement smt = hospital.createStatement();
			ResultSet res = smt.executeQuery("select * from doctor");

			System.out.println("+~~~~~~~~+~~~~~~~~~~~~~~~~~~~~+~~~~~~~~~~~~~~~~~~~+");
			System.out.println("|      ID|                NAME|     SPECIALIZATION|");
			System.out.println("+~~~~~~~~+~~~~~~~~~~~~~~~~~~~~+~~~~~~~~~~~~~~~~~~~+");

			while (res.next()) {
				System.out.println(String.format("|%8s|%20s|%8s|", res.getInt(1), res.getString(2), res.getInt(3)));
				System.out.println("+--------+--------------------+--------+--------+");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
