package Railway;

import Railway.Tickets.Ticket;
import Railway.Accounts.Admin;
import Railway.Accounts.User;
import java.util.*;

public class RailwayReservation
{
	Scanner s = new Scanner(System.in);
	public static ArrayList<Admin> admins = new ArrayList<>();
	public static ArrayList<User> users = new ArrayList<>();
	
	public static LinkedList<Ticket> tickets = new ArrayList<>();
	public static LinkedList<Ticket> waitingList = new LinkedList<>();
	public static LinkedList<Ticket> RAC = new LinkedList<>();
	
	public static void main(String args[])
	{
		RailwayReservation r = new RailwayReservation();
		admins.add(new Admin(101, "admin", "nimda"));
		
		for(int i = 1 ; i < 64 ; i++) {
			tickets.add(new Ticket(i));
		}
		
		r.logIn();
		System.exit(0);
	}
	
	public void logIn()
	{
		boolean loop = true;
		int choice;
			
		while(loop)
		{
			System.out.println("***************************************");
			System.out.println("* * * * * RAILWAY RESERVATION * * * * *");
			System.out.println("***************************************");
			System.out.println("\n\nSelect the type of login\n1. Admin\n2. User\n3. Exit");
			choice = s.nextInt();
			
			switch(choice)
			{
				case 1: adminLogin();
				break;
				
				case 2: userLogin();
				break;
				
				case 3: System.out.println("Thank you for using this portal.");
				loop = false;
				break;
				
				default: System.out.println("Invalid choice, try again");
				continue;
			}
		}		
	}
	
	public void adminLogin()
	{
		System.out.println("Enter the admin ID: ");
		int id = s.nextInt();
		
		for(Admin a : admins)
		{
			if(id == a.getId())
			{
				System.out.println("Enter name: ");
				String name = s.next();
				System.out.println("Enter password: ");
				String password = s.next();
				if(name.equals(a.getName())  && a.checkPassword(password))
				{
					adminPage(a);
					return;
				}
				System.out.println("Password or account name mismatch!");
				return;
			}				
		}
		
		System.out.println("Cannot find account for the given id");
		return;
	}
	
	public void userLogin()
	{
		boolean loop = true;
		int choice;
		
		System.out.println("Enter the user ID: ");
		int id = s.nextInt();
		
		for(User u : users)
		{
			if(id == u.getId())
			{
				System.out.println("Enter name: ");
				String name = s.next();
				System.out.println("Enter password: ");
				String password = s.next();
				if(name.equals(u.getName())  && u.checkPassword(password))
				{
					userPage(u);
					return;
				}
				System.out.println("Password or account name mismatch!");
				return;
			}				
		}
		
		System.out.println("Cannot find account for the given id");
		return;
	}
	
	public void adminPage(Admin admin)
	{
		boolean loop = true;
		
		while(loop)
		{
			System.out.println("\nLogged in as Admin: " + admin.getName());
			System.out.println("Menu:\n" + "1. See all tickets\n" + "2. Book Ticket\n" + "3. Cancel Ticket\n" + "4. Exit");
			
			int choice = s.nextInt();
			
			switch(choice)
			{
				case 1: admin.printTickets();
				break;
				
				case 2: admin.bookTickets();
				break;
				
				case 3: admin.cancelTicket();
				break;
				
				case 4: loop = false;
				break;
				
				default: System.out.println("Invalid choice");
			}
		}		
	}
	
	public void userPage(User user)
	{
		boolean loop = true;
		
		while(loop)
		{
			System.out.println("\nLogged in as User: " + user.getName());
			System.out.println("Menu:\n" + 
			"1. See all tickets\n" +
			"2. Book Ticket\n" +
			"3. Cancel Ticket\n" + 
			"4. Exit");
			
			int choice = s.nextInt();
			
			switch(choice)
			{
				case 1: user.printTickets();
				break;
				
				case 2: user.bookTickets();
				break;
				
				case 3: user.cancelTicket();
				break;
				
				case 4: loop = false;
				break;
				
				default: System.out.println("Invalid choice");
			}
		}		
	}
}