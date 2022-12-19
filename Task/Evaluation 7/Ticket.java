package Railway.Tickets;

import java.util.*;

public class Ticket
{
	private int seatNum = -1;
	private char berth  = '-';
	private boolean booked = false;
	private String bookedFor = "" ;
	private int age = -1;
	private char gender = '-';
	
	
	public Ticket(int seat)
	{
		this.seatNum = seat;
		switch(seat % 3)
		{
			case 0 : berth = 'U';
			break;
			
			case 1 : berth = 'M';
			break;
			
			case 2 : berth = 'L';
			break;
		}
	}
	
	public char getBerth()
	{
		return berth;
	}
	
	public boolean bookThisTicket(String name, int age, char gender)
	{
		if(!booked) {
			this.bookedFor = name;
			this.age = age;
			this.gender = gender;
			booked = true;
			return true;
		}
		return false;
	}
	
	public boolean bookThisTicket(String name, int age, char gender)
	{
		if(!booked) {
			this.bookedFor = name;
			this.age = age;
			this.gender = gender;
			booked = true;
			return true;
		}
		return false;
	}
	
	public boolean cancelThisTicket()
	{
		if(booked) {
			this.bookedFor = "";
			this.age = -1;
			this.gender = '-';
			booked = false;
			return true;
		}
		return false;
	}
	
	public boolean isBooked()
	{
		return booked;
	}
	
	public String toString()
	{
		if(booked)
			return seatNum + ": " + berth + ": " + bookedFor + ": " + age + ": " + gender;
		else 
			return seatNum + ": " + berth + ": " + "NOT BOOKED";
	}
}