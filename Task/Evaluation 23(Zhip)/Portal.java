package Zhip;

import Zhip.user.User;
import java.util.*;
import java.io.*;

public class Portal
{
	static HashMap<String, User> users = new HashMap<>();
	static Scanner s = new Scanner(System.in);
	
	public static void portal() throws Exception 
	{
		Portal port = new Portal();
		
		out : while(true) {
			port.clear();
			System.out.println("# - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - #");
			System.out.println("|                            Zhip                             |");
			System.out.println("|                     To build(riendship)                     |");
			System.out.println("# - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - #");
			
			System.out.println("What's on your mind ? \n\t\t1. Log-in \n\t\t2. Sign-up");
			switch(s.nextInt())
			{
				case 1 : {
					port.clear();
					System.out.println("Enter username : ");
					String username = s.next();
					System.out.println("Enter password : ");
					String password = s.next();
					
					if(!users.containsKey(username))
					{
						System.out.println("Hmm .. We can't find a account with that username. \nIf you like to join us, sign up ?");
						break;
					}
					
					if(users.get(username).authenticate(password))
						port.login(username);
					else
						System.out.println("That password is not matching with the username you entered :-(");
					break;
				}
				
				case 2 : {
					port.clear();
					System.out.println("# - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - #");
					System.out.println("|                            Zhip                             |");
					System.out.println("|                   Making ourselves better                   |");
					System.out.println("# - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - #");
					
					System.out.print("\n\nEnter your first name : ");
					String fname = s.next();
					System.out.print("\n\nEnter your last name : ");
					String lname = s.next();
					System.out.print("\n\nEnter username : ");
					String uname = s.next();
					
					if(users.containsKey(uname))
					{
						System.out.println("\n\nUsername already taken try another username");
						Thread.sleep(5000);
						break;
					}
					
										
				}
				
				case 3 : {
					break out;
				}
				
				default : {
					System.out.println("Innoru chance kodukuren ... correct number input kodunga");
				}
			}
			
			break;
		}
	}
	
	public void login(String username)
	{
		return;
	}
	
	public void clear() throws IOException, InterruptedException
	{
		// for(int i = 0 ; i < 60 ; i++)
			// System.out.println();
		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	}
}