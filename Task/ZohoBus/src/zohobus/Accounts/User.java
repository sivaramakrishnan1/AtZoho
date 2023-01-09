package ZohoBus.Accounts;

import java.util.ArrayList;
import java.util.List;

import ZohoBus.Ticket;

public class User {
	private String username, password;
	private List<Ticket> tickets = new ArrayList<>();
	
	User (String username, String password)
	{
		this.username = username;
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}

	public boolean authenticate(String password) {
		if(this.password.equals(password))
			return true;
		return false;		
	}
	
	public void addTicket(Ticket t)
	{
		tickets.add(t);
	}
	
	public void viewTicket()
	{
		for (Ticket ticket : tickets) {
			System.out.println(ticket.toString());
		}
	}
	
}
