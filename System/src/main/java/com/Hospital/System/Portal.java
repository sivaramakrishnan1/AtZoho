package com.Hospital.System;

import java.io.Console;
import java.util.Scanner;

public class Portal {
	static Scanner s = new Scanner(System.in);
	static Console c = System.console();

	public static void start() {
		Portal p = new Portal();
		p.login();
	}

	public void login() {
		System.out.println("Hospital System - Login" + "\n\t\t1. Admin login" + "\n\t\t2. Doctor login "
				+ "\n\t\t3. Receptionist login");

		switch (s.nextInt()) {
		// admin login
		case 1:
			System.out.println("Enter username : ");
			String username = s.next();

			System.out.println("Enter password : ");
			String password = String.valueOf(c.readPassword());

			break;

		}
	}
}
