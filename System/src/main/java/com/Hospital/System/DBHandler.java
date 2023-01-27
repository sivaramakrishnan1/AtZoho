package com.Hospital.System;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

public class DBHandler {
	static Scanner s = new Scanner(System.in);
	Connection hospital;
	Statement smt;

	@Override
	protected void finalize() throws Throwable {
		s.close();
		hospital.close();
		smt.close();
		super.finalize();
	}

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
			if (res.next())
				return res.getInt(1);
			return -1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	public void createAppointment() {

		printPatients();

		System.out.println("Enter the id of the patient : ");
		int patientId = s.nextInt();

		printDoctors();

		System.out.println("Enter doctor's ID : ");
		int docId = s.nextInt();

		LocalDateTime lastTime = getLastAppointment(docId);

		Timestamp begin = Timestamp.valueOf(lastTime);
		Timestamp end = Timestamp.valueOf(lastTime.plusHours(1));

		System.out.println("insert into appointment(patient_id, doctor_id, begins, ends) values(" + patientId + ", "
				+ docId + ", '" + begin + "', '" + end + "');");
		queryUpdate("insert into appointment(patient_id, doctor_id, begins, ends) values(" + patientId + ", " + docId
				+ ", '" + begin + "', '" + end + "');");
		System.out.println("Appointment created .. ");

	}

	public LocalDateTime getLastAppointment(int docId) {
		try {
			ResultSet res = smt.executeQuery("select MAX(begins) from appointment where doctor_id = " + docId);

			if (!res.next() || res.getTimestamp(1) == null)
				if (LocalTime.now().isAfter(LocalTime.of(21, 0)))
					return LocalDateTime.of(LocalDate.now().plusDays(1), LocalTime.of(8, 30));
				else
					return LocalDateTime.of(LocalDate.now(), LocalTime.now());

			Timestamp lasttime = res.getTimestamp(1);

			if (LocalDateTime.now().isAfter(lasttime.toLocalDateTime().plusHours(1)))
				return LocalDateTime.of(LocalDate.now(), LocalTime.now());

			return lasttime.toLocalDateTime().plusHours(1);

		} catch (SQLException e) {
			System.out.println("Error with the process : " + e);
			e.printStackTrace();
		}

		return LocalDateTime.of(LocalDate.now(), LocalTime.of(8, 30));
	}

	public void printAppointments() {
		try {
			ResultSet res = smt.executeQuery(
					"select appointment.appointment_id, patient.name, doctor.name, appointment.begins, appointment.ends, appointment.status from appointment"
							+ "\ninner join patient on appointment.patient_id = patient.patient_id"
							+ "\ninner join doctor on appointment.doctor_id = doctor.doctor_id;");

			System.out.println(
					"+-----+--------------------+--------------------+--------------------+--------------------+--------------------+");
			System.out.println(
					"|   ID|        PATIENT NAME|         DOCTOR NAME|                FROM|                  TO|              STATUS|");
			System.out.println(
					"+-----+--------------------+--------------------+--------------------+--------------------+--------------------+");

			while (res.next()) {
				System.out.println(String.format("|%5s|%20s|%20s|%20s|%20s|%20s|", res.getInt(1), res.getString(2),
						res.getString(3), res.getString(4), res.getString(5), res.getString(6)));
				System.out.println(
						"+-----+--------------------+--------------------+--------------------+--------------------+--------------------+");
			}
		} catch (SQLException e) {
			System.out.println("Failed to display all data : " + e);
		}

	}

	public void printAppointments(int id) {
		try {
			ResultSet res = smt.executeQuery(
					"select appointment.appointment_id, patient.name, doctor.name, appointment.begins, appointment.ends, appointment.status from appointment"
							+ "\ninner join patient on appointment.patient_id = patient.patient_id"
							+ "\ninner join doctor on appointment.doctor_id = doctor.doctor_id where appointment.doctor_id = "
							+ id + ";");

			System.out.println(
					"+-----+--------------------+--------------------+--------------------+--------------------+--------------------+");
			System.out.println(
					"|   ID|        PATIENT NAME|         DOCTOR NAME|                FROM|                  TO|              STATUS|");
			System.out.println(
					"+-----+--------------------+--------------------+--------------------+--------------------+--------------------+");

			while (res.next()) {
				if (res.getString(6).equals("NOT_VISITED")) {
					System.out.println(String.format("|%5s|%20s|%20s|%20s|%20s|%20s|", res.getInt(1), res.getString(2),
							res.getString(3), res.getString(4), res.getString(5), res.getString(6)));
					System.out.println(
							"+-----+--------------------+--------------------+--------------------+--------------------+--------------------+");
				}
			}
		} catch (SQLException e) {
			System.out.println("Failed to display all data : " + e);
		}

	}

	public void updateAppointment(int id, String status) {
		if (id == -1)
			printAppointments();
		else
			printAppointments(id);

		System.out.println("Enter the id of the appointment to change the status : ");
		int appId = s.nextInt();

		queryUpdate("update appointment set status = " + status + " where appointment_id = " + appId + " ;");

		if (id == -1)
			return;
		try {
			ResultSet res = smt.executeQuery("select fees from doctor where doctor_id = " + id);
			int amount = res.getInt(1);
			queryUpdate("insert into bill(appointment_id, amount) values(" + appId + " , " + amount + " )");
		} catch (SQLException e) {
			System.out.println(e);
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

			System.out.println("\t\tDoctor fee : ");
			int fee = s.nextInt();

			queryUpdate("insert into doctor(name, username, password, specialization) values(\"" + docname + "\",\""
					+ docUserName + "\", MD5(\"" + password + "\"),\"" + special + "\");");
			System.out.println("Account created");

		} catch (Exception e) {
			System.out.println("Sothanaigal ... " + e);
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

	public void printBills() {
		try {
			ResultSet res = smt.executeQuery("select bill.bill_id, patient.name, bill.amount from bill "
					+ "inner join appointment on bill.appointment_id = appointment.appointment_id "
					+ "inner join patient on appointment.patient_id = patient.patient_id;");
			System.out.println("+--------+--------------------+--------+");
			System.out.println("|      ID|        PATIENT NAME|  AMOUNT|");
			System.out.println("+--------+--------------------+--------+");

			while (res.next()) {
				System.out.println(String.format("|%8s|%20s|%8s|", res.getInt(1), res.getString(2), res.getInt(3)));
				System.out.println("+--------+--------------------+--------+");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void payBills() {
		printPatients();
		System.out.println("Enter patient id : ");
		int pid = s.nextInt();
		float amount = 0;
		try {
			ResultSet res = smt.executeQuery("select bill.bill_id, doctor.name, bill.amount from bill "
					+ "inner join appointment on bill.appointment_id = appointment.appointment_id "
					+ "inner join doctor on appointment.doctor_id = doctor.doctor_id "
					+ "inner join patient on appointment.patient_id = patient.patient_id where appointment.patient_id = "
					+ pid);

			System.out.println("+--------+--------------------+--------+");
			System.out.println("|      ID|         DOCTOR NAME|  AMOUNT|");
			System.out.println("+--------+--------------------+--------+");

			while (res.next()) {
				System.out.println(String.format("|%8s|%20s|%8s|", res.getInt(1), res.getString(2), res.getInt(3)));
				amount += res.getInt(3);
			}

			System.out.println("+--------+--------------------+--------+");
			System.out.println(String.format("|%29s|%8s|", "Grand Total", amount));
			System.out.println("+--------+--------------------+--------+");

			System.out.println("\n\nPay now ? (y/n)");

			if (s.next().equalsIgnoreCase("n"))
				return;

			queryUpdate("delete bill from bill "
					+ "inner join appointment on appointment.appointment_id = bill.appointment_id "
					+ "inner join patient on appointment.patient_id = patient.patient_id where patient.patient_id ="
					+ pid);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void queryUpdate(String command) {
		try {
			smt.executeUpdate(command);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}