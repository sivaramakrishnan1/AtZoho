package zohobus;

import java.util.Iterator;

import zohobus.accounts.User;

public class Bus {
	Agency agency;
	String busName;
	Ticket[] seats;
	String[] stops;
	float[] fare;

	public Bus(String busName, int size, String[] stops, float[] fare, Agency agency) {
		this.agency = agency;
		this.busName = busName;
		this.seats = new Ticket[size];
		this.stops = stops;
		this.fare = fare;
	}

	public String getBusName() {
		return this.busName;
	}

	public int isOnTheWay(String stop) {
		for (int i = 0; i < stops.length; i++) {
			if (stops[i].equals(stop))
				return i;
		}

		return -1;
	}

	public float countFare(String from, String to) {
		int frompos = isOnTheWay(from), topos = isOnTheWay(to);

		if (frompos == -1 || topos == -1)
			return -1;
		float fareCount = 0;

		if (frompos < topos)
			for (int i = isOnTheWay(from); i < isOnTheWay(to); i++)
				fareCount += fare[i];
		else
			for (int i = isOnTheWay(from) - 1; i > isOnTheWay(to) - 1; i--)
				fareCount += fare[i];

		return fareCount;

	}

	public void printSeats() {
		for (int i = 0; i < seats.length; i++) {
			if (seats[i] != null)
				System.out.print(" X ");
			else
				System.out.print(" " + (i + 1) + " ");
			if (i % 3 == 0)
				System.out.println();
		}
	}

	public boolean bookSeat(int seatno, String from, String to, String date, User u) {
		if (!isFree(seatno))
			return false;

		float fare = countFare(from, to);
		seats[seatno] = new Ticket(from, to, date, seatno, fare, u);
		return true;
	}

	public boolean isFree(int seatno) {
		if(seats[seatno -1] == null) return true;
		return false;
	}
	
	public int freeSeatCount()
	{
		int count = 0;
		for (Ticket t : seats) {
			if(t == null)
				count++;
		}
		
		return count;
	}
	
	@Override
	public String toString() {
		return String.format("%-20s | Free seats : %-20s", "", agency.getUsername(), freeSeatCount());
	}
}