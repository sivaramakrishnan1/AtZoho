package zohobus;

import java.io.Serializable;

import zohobus.accounts.User;

public class Ticket implements Serializable {
	private String from, to, date;
	private int seatno;
	private User bookedFor;
	private float fare;

	public Ticket(String from, String to, String date, int seatno, float fare, User user)
	{
		this.from = from;
		this.to = to;
		this.date = date;
		this.seatno = seatno;
		this.bookedFor = user;
	}

	public String getFrom() {
		return from;
	}

	public String getTo() {
		return to;
	}

	public String getDate() {
		return date;
	}
	
	@Override
	public String toString()
	{
		return String.format("%-15s%-15s%-10s%-10d%-20s", from, to, date, seatno, bookedFor.getUsername());	
	}
	
}
