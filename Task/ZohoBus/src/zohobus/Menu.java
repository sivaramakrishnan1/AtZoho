package ZohoBus;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ZohoBus.Accounts.Admin;
import ZohoBus.Accounts.User;

public class Menu 
{
	private static List<User> users = new ArrayList<>();
	private static List<Admin> admins = new ArrayList<>();
	
	public static void login()
	{
		Scanner s = new Scanner(System.in);
		Menu m = new Menu();
		
		loop : while(true)
		{
			System.out.println("\n\n\t\tZoho Bus Log-in" + 
			"\nSelect one from the option" + 
			"\n1. User login" + 
			"\n2. Travel Agency login" + 
			"\n3. Admin login" + 
			"\n4. Exit");
			
			switch(s.nextInt())
			{
			case 1: 
				System.out.println("Enter your username: ");
				String username = s.next();
				
				System.out.println("Enter your password: ");
				String password = s.next();
				
				for (int i = 0; i < users.size(); i++) {
					if(users.get(i).getUsername().equals(username) && users.get(i).authenticate(password)) {
						userLogin(i);
						break;
					}					
				}
				System.out.println("The username/password you entered is invalid");
				break;
				
			case 4 : 
				break loop;
				
			default :
				System.out.println("Invalid choice");
				break;
			}		
		}
	}
	
	public void userLogin(int pos)
	{
		
		
	}
}
