import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

class ZEmployee implements Serializable
{
	String email;
	double exchangeRate = 2;
	
	private String password;
	private List<User> approvalList = new ArrayList<>();
	List<Transaction> transactions = new ArrayList<>();
		
	
	
	ZEmployee(String email, String password)
	{
		this.email = email;
		this.password = encrypt(password);
	}
	
	private String encrypt(String password)
	{
		String enc = "";
		
		for(int i = 0 ; i < password.length() ; i++)
		{
			if(password.charAt(i) == 'z') enc += "a";
			else if(password.charAt(i) == 'Z') enc += "Z";
			else if(password.charAt(i) == '9') enc += "0";
			else enc += (char)(password.charAt(i) + 1) + "";
		}
		
		return enc;
	}
	
	public void requestApproval(User u)
	{
		approvalList.add(u);
	}
	
	public boolean authentication(String password)
	{
		return this.password.equals(encrypt(password));
	}
	
	public void processApprovalList()
	{
		Scanner s = new Scanner(System.in);
		for(int i = 0 ; i < approvalList.size() ; i++)
		{
			System.out.println(approvalList.get(i));
			System.out.println("1. Approve, 2. Reject, 3. Verify later");
			switch(s.nextInt())
			{
				case 1 : {
					approvalList.get(i).zid = ++Portal.zidGen;
					Portal.accounts.add(approvalList.get(i));
					approvalList.remove(i);
					break;
				}
				
				case 2 : {
					approvalList.remove(i);
					break;
				}
				
				case 3 : break;
				
				default : {
					System.out.println("Invalid input, please try again");
					i--;
					break;
				}
			}
		}
		s.close();
	}
	
	public void setExchangeRate(double rate)
	{
		if(rate > 0)
		this.exchangeRate = rate;
	}
	
	public void viewAllTransactions()
	{
		for(Transaction t : transactions)
			System.out.println(t);
	}
	
	public double allZcoins()
	{
		double total = 0;
		
		for(User u : Portal.accounts)
			total += u.getZCurrencyBalance();
		
		return total;
	}
	
	
	public void transactionZCurrency(int id)
	{
		for(Transaction t : transactions)
			if(t.from == Portal.accounts.get(id) && t.isZCoinTransaction)
				System.out.println(t);
	}	
	
	public void transactionRCurrency(int id)
	{
		for(Transaction t : transactions)
			if(t.from == Portal.accounts.get(id) && !t.isZCoinTransaction)
				System.out.println(t);
	}
}