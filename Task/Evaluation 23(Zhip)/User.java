package Zhip.user;
import java.util.*;

public class User 
{
	// static {
		// overallId = Portal.users.size() + 1;
	// }
	
	private String firstname, lastname, encpassword, username, email, phno;
	private static int overallId = 1;
	private int id, age;
	private List<User> friends = new ArrayList<>();
	private List<User> friendReq = new ArrayList<>();
	
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
		String enc = "";
		
		for(int i = 0 ; i < password.length() ; i++)
		{
			enc += (char)(password.charAt(i) + i);
		}
		
		return enc;
	}
	
	public boolean authenticate(String password)
	{
		return this.encpassword.equals(encrypt(password));
	}
	
	public String getFirstName()
	{
		return this.firstname;
	}
	
	public String getLastName()
	{
		return this.lastname;
	}
	
	public int getId()
	{
		return this.id;
	}
	
	public void setFirstName(String firstname)
	{
		this.firstname = firstname;
	}
	
	public void setLastName(String lastname)
	{
		this.lastname = lastname;
	}
	
	public void setPassword(String password)
	{
		this.encpassword = encrypt(password);
	}
	
	public void printFriends()
	{
		for(User u : friends)
			System.out.println(u.getFirstName() + " " + u.getLastName());
	}
	
	public void printRequests()
	{
		for(User u : friendReq)
			System.out.println(u.getFirstName() + " " + u.getLastName());
	}
}