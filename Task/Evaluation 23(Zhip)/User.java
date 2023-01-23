package zship.user;

import java.util.*;
import java.io.*;

public class User implements Serializable	
{
	static final long serialVersionUID = 904779;
	// static {
		// overallId = Portal.users.size() + 1;
	// }
	
	public String firstname, lastname, encpassword, username, email, phno;
	public static int overallId = 1;
	public int id, age;
	public List<User> friends = new ArrayList<>();
	public List<User> friendReq = new ArrayList<>();
	
	public User (String username, String firstname, String lastname, String password, String email, int age, String phno) 
	{
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.encpassword = encrypt(password);
		this.age = age;
		this.email = email;
		this.phno = phno;
		this.id = overallId++;
	}
	
	public String encrypt(String password)
	{
		String encrypted = "";
		
		for(int i = 0 ; i < password.length() ; i++)
		{
			if(password.charAt(i) == 'z') encrypted += "a";
			else if(password.charAt(i) == 'Z') encrypted += "A";
			else if(password.charAt(i) == '9') encrypted += "0";
			else encrypted += (char)(password.charAt(i) + 1);			
 		}
		
		return encrypted;
	}
	
	public boolean authenticate(String password)
	{
		password = encrypt(password);
		return password.equals(this.encpassword);
	}
	
	public void printFriends()
	{
		for(User u : friends)
			System.out.println(u.firstname + " " + u.lastname);
	}
	
	public void printRequests()
	{
		for(User u : friendReq)
			System.out.println(u.firstname + " " + u.lastname);
	}
	
	public void removeFriend(String user)
	{
		for(int i = 0 ; i < friends.size() ; i++)
		{
			if(friends.get(i).username.equals(user))
			{
				friends.remove(i);
				System.out.println("\t\t- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
				System.out.println("\t\t|                        Removed                            |");
				System.out.println("\t\t- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
				return;
			}
		}
		
		System.out.println("\t\t- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		System.out.println("\t\t|                    No such friend found                   |");
		System.out.println("\t\t- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
	}
	
	public String toString()
	{
		return String.format("%20s : %s\n%20s : %s\n%20s : %s\n%20s : %s\n%20s : %s\n", "User id", this.id, "Username", this.username, "First name", this.firstname, "Last name", this.lastname, "email", this.email, "Phone", this.phno);
	}
}