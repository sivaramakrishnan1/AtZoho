import java.util.Scanner;
import java.io.*;

public class Account
{
	private int id, accntNo;
	private String name, encPwd;
	private float balance;
	
	int transId = 0;
	
	public Account(int id, int accntNo, String name, String encPwd, float balance)
	{
		this.id = id;
		this.accntNo = accntNo;
		this.name = name;
		this.encPwd = encPwd;
		this.balance = balance;
		++transId;
	}
	
	public Account(int id, int accntNo, String name, String encPwd)
	{
		this.id = id;
		this.accntNo = accntNo;
		this.name = name;
		this.encPwd = encryptPassword(encPwd);
		this.balance = 10000;
		
		try {
			updateFile("Account Created");
		} catch(Exception e) {
			System.out.println("FILE_UPDATE_FAILED"); 
		} 
	}
	
	public boolean authenticate(String password)
	{
		password = encryptPassword(password);
		return password.equals(this.encPwd);
	}
	
	public boolean changeBalance(float val, String message) 
	{
		try 
		{
			if(balance + val < 1000) {
				throw new MinimumBalanceException(balance);
			}
			this.balance += val;
		} catch(MinimumBalanceException e)
		{
			System.out.println(e);
			return false;
		}
		
		try {
			updateFile(message);
		} catch(Exception e) {
			System.out.println("FILE_UPDATE_FAILED"); 
		} 
		
		return true;
	}
	
	public String encryptPassword(String password)
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
	
	public int getId()
	{
		return this.id;
	}
	
	public int getAccountNumber()
	{
		return this.accntNo;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public float getBalance()
	{
		return this.balance;
	}
	
	public boolean setPassword(String password) throws Exception
	{
		this.encPwd = encryptPassword(password);
		try {
			updateFile("Password change");
		} catch(Exception e) {
			System.out.println("FILE_UPDATE_FAILED"); 
		} 
		return true;
	}
	
	public String toReadableString(String message)
	{
		return String.format("%-10d%-20s%-10f\n", ++transId, message, this.balance);
	}
	
	public String toString()
	{
		return this.id + " " + this.accntNo + " " + this.name + " " + this.encPwd + " " + this.balance + "\n";
	}
	
	public void transactionReader() throws Exception
	{
		Scanner reader = new Scanner(new File("Account\\"+id+".txt"));
		transId = 0;
		while(reader.hasNext())
		{
			reader.nextLine();
			++transId;
		}
		reader.close();
	}
	
	public void updateFile(String message) throws Exception
	{
		FileWriter writer = new FileWriter("Account\\"+id+".txt", true);
		writer.write(toReadableString(message));
		writer.close();
	}
}

class MinimumBalanceException extends Exception
{
	float balance = 0;
	
	MinimumBalanceException(float balance)
	{
		this.balance = balance;
	}
	
	public String toString()
	{
		return "Minimum balance cannot go below 1000";
	}
}