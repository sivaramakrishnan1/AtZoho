import java.util.*;
import java.io.*;

class Bank
{
	static int permId = 0;
	
	private static List<Account> users = new ArrayList<>();
	
	public void initialize(String information) throws Exception
	{
		String[] data = information.split(" ");
		
		users.add(new Account(Integer.parseInt(data[0]), Integer.parseInt(data[1]), data[2], data[3], Float.parseFloat(data[4])));
		users.get(users.size() - 1).transactionReader();
		++permId;
	}
	
	public boolean addAccount(int accNo, String name, String password)
	{
		// checking another account with same account number
		if(idOfAccountNumber(accNo) != -1) return false;
		
		users.add(new Account(++permId, accNo, name, password));
		
		try {
			updateToFile();
		} catch(Exception e) {
			System.out.println("FAILED_UPDATING_FILE");
		}
		
		return true;
	}
	
	public int idOfAccountNumber(int accountNumber)
	{
		for(Account a : users)
		{
			if(a.getAccountNumber() == accountNumber) return a.getId();
		}
		return -1;
	}
	
	public boolean withdraw(int id, float amount)
	{
		return users.get(id).changeBalance(-1*amount, "Withdraw");
	}
	
	public boolean deposit (int id, float amount)
	{
		return users.get(id).changeBalance(amount, "Deposit");
	}
	
	public boolean transfer(int from, int to, float amount)
	{
		if(users.get(from).changeBalance(-1 * amount, "Transfer to " + users.get(from).getName()))
		{
			users.get(to).changeBalance(amount, "Transfer from " + users.get(to).getName());
			return true;
		}
		return false;
	}
	
	public float getBalance(int id) 
	{
		return users.get(id).getBalance();
	}
	
	public void updateToFile() throws Exception
	{
		FileWriter writer = new FileWriter("bank_db.txt");
		writer.write("BANK DATABASE\n");
		for(int i=0 ; i<users.size() ; i++)
		{
			writer.write(users.get(i).toString());
		}
		
		writer.close();
	}
	
	public boolean setPassword(int id, String password)
	{
		users.get(id).setPassword(password)
	}
	
	public boolean authenticate(int id, String password)
	{
		return users.get(id).authenticate(password);
	}
}
