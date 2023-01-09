package zohobus.accounts;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import zohobus.Ticket;

public class User implements Serializable {
	private String username, password;
	private List<Ticket> tickets = new ArrayList<>();
	
	public User (String username, String password)
	{
		this.username = username;
		this.password = encryptPassword(password);
	}
	
	public String getUsername() {
		return username;
	}

	public boolean authenticate(String password) {
		password = encryptPassword(password);
		return password.equals(this.password);
	}

	public String encryptPassword(String password) {
		String encrypted = "";

		for (int i = 0; i < password.length(); i++) {
			if (password.charAt(i) == 'z')
				encrypted += "a";
			else if (password.charAt(i) == 'Z')
				encrypted += "A";
			else if (password.charAt(i) == '9')
				encrypted += "0";
			else
				encrypted += (char) (password.charAt(i) + 1);
		}

		return encrypted;
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
