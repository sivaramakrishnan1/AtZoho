package Parking.Tickets;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TicketHandler
{
	static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	static Date date = new Date();
	public void parkVehicle(String number, String type, String ticket)
	{
		String activity = "Parked";
		try 
		{
			FileWriter writer = new FileWriter("Parking//Tickets//log.txt", true);
			writer.write( String.format("%15s%15s%15s%15s%25s\n", number, type, ticket, activity, formatter.format(date)));
			writer.close();
		} 
		catch(IOException e) 
		{
			System.out.println("Some problem with adding ticket to the log");
		}
	}
	
	public void unparkVehicle(String number, String type, String ticket)
	{
		String activity = "Unparked";
		try 
		{
			FileWriter writer = new FileWriter("Parking//Tickets//log.txt", true);
			writer.write( String.format("%15s%15s%15s%15s%25s\n", number, type, ticket, activity, formatter.format(date)));
			writer.close();
		} 
		catch(IOException e) 
		{
			System.out.println("Some problem with adding ticket to the log");
		}
	}
	
	
}