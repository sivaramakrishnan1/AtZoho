import java.util.regex.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

class Portal implements Serializable
{
	static int tidGen = 100, zidGen = 1000;
	static List<User> accounts = new ArrayList<>();
	Scanner s = new Scanner(System.in);
	ZEmployee ze = new ZEmployee("admin@zverse.com", "Zverse#1");
	
	public void serialize()
	{
		try {
			List staticValues = new ArrayList<>();
			staticValues.add(tidGen);
			staticValues.add(zidGen);
			staticValues.add(accounts);
			staticValues.add(ze);
			
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Content.secured"));
			oos.writeObject(staticValues);
			oos.close();
		}
		catch(Exception e) {
			System.out.println("Error aaiduchu bha : " + e);
		}
	}
	
	public void deserialize()
	{
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Content.secured"));
			List staticValues = (List)ois.readObject();
			ois.close();
			
			tidGen = (int) staticValues.get(0);
			zidGen = (int) staticValues.get(1);
			accounts = (List) staticValues.get(2);
			ze = (ZEmployee) staticValues.get(3);
		} catch(Exception e) {
			System.out.println("Error aaiduchu bha : " + e);
		}
	}
	
	public void homeLogin() throws UserNotFoundException, PasswordMismatchException
	{
		deserialize();
		
		out : while(true) {
			System.out.println("Welcome, enter \n1. For ZE login\n2. For User login\n3. For User sign-up\n4. Exit");
			
			switch(s.nextInt())
			{
				case 1 : 
				{
					String email, password;
					
					do {
						System.out.print("\nEnter your email : ");
						email = s.next();
					}while(!isEmailAddress(email));
					
					System.out.print("\nEnter your password : ");
					password = s.next();
					
					if(!ze.email.equals(email) || !ze.authentication(password)) {
						throw new UserNotFoundException();
					}						
					
					ZEPortal();
					break;
				}
				
				case 2 :
				{
					int id = -1;
					
					System.out.println("Enter your email : ");
					String email = s.next();
					
					for(int i = 0 ; i < accounts.size() ; i++)
					{
						if(email.equals(accounts.get(i).email)) {
							id = i;
							break;
						}
					}
					
					if(id == -1) throw new UserNotFoundException();
					
					System.out.println("Enter your password : ");
					String password = s.next();
					
					if(accounts.get(id).authentication(password))
						UserPortal(id);
					else
						throw new PasswordMismatchException();
					break;
				}
				
				case 3 : 
				{
					String hid, name, email, number, password; 
					double RCurrency;
					
					System.out.println("Enter your humain ID");
					hid = s.next();
					System.out.println("Enter your name");
					s.nextLine();
					name = s.nextLine();
					System.out.println("Enter your email");
					email = s.next();
					System.out.println("Enter your number");
					number = s.next();
					System.out.println("Enter your password");
					password = s.next();
					System.out.println("Enter your initial deposit");
					RCurrency = s.nextDouble();
					
					ze.requestApproval(new User(hid, name, email, number, password, RCurrency));
					break;
				}
				case 4 :
				break out;
				
				default :
				System.out.println("Invalid input");
			}
		}	
		serialize();
	}
	
	void ZEPortal()
	{
		/*
		Change exchange rate
		approve/reject accounts
		view all transactions
		view all ZCoins
		view all commisions from each user
		*/
		
		out : while(true)
		{
			System.out.println("Choose an option : "
			+ "\n1. Change exchange rate" 
			+ "\n2. Approve/reject accounts"
			+ "\n3. View all transactions"
			+ "\n4. View all ZCoins"
			+ "\n5. View all commisions from each user"
			+ "\n6. Exit");
			int choice = s.nextInt();
			switch(choice)
			{
				case 1 : 
				{
					System.out.println("Current exchange rate : " + ze.exchangeRate);
					System.out.println("Enter the new exchange rate : ");
					double rate = s.nextDouble();
					
					ze.setExchangeRate(rate);
					break;
				}
				
				case 2 :
				{
					ze.processApprovalList();
					break;
				}
				
				case 3 :
				{
					ze.viewAllTransactions();
					break;
				}
				
				case 4 : 
				{
					System.out.println(ze.allZcoins());
					break;
				}
				
				case 5 :
				{
					ze.viewAllTransactions();
					break;
				}
				
				case 6 : break out;
				default : System.out.println("\nInvalid input, please try again.");
			}			
		}
	}
	
	void UserPortal(int id)
	{
		/*
		display wallet
		transactions RC to 
		*/
		out : while(true)
		{
			System.out.println("Menu : "
			+ "\n1. Display wallet"
			+ "\n2. Transactions RCurrency"
			+ "\n3. Transactions ZCurrency"
			+ "\n4. Exit");
			switch(s.nextInt())
			{
				case 1 : System.out.println("\nZCurrency : Z" + accounts.get(id).getZCurrencyBalance() + "\nRCurrency : Rs. " + accounts.get(id).getRCurrencyBalance());
				break;
				
				case 2 : ze.transactionRCurrency(id); break;
				
				case 3 : ze.transactionZCurrency(id); break;
				
				case 4 : break out;				
			}
		}
		
	}
	
	boolean isValidPassword(String password)
	{
		String[] patterns = {"[a-z]", "[A-Z]", "[0-9]", ".{8,}", "[_-*@#$%&]"};
		
		for(int i = 0 ; i < patterns.length ; i++)
		{
			Pattern p = Pattern.compile(patterns[i]);
			Matcher m = p.matcher(password);
			if(!m.find()) {
				System.out.println("Password format mismatch. Password must contain lowercase alphabet(s), uppercase alphabet(s), number(s), a special character and must be longer than 5 characters");
				return false;
			}
		}		
		return true;		
	}
	
	boolean isEmailAddress(String email)
	{		
		if(email.matches("[A-Za-z0-9._%+\\-]+@[A-Za-z0-9.\\-]+\\.[A-Za-z]{2,6}"))
			return true;
		
		System.out.println("Email format mismatch");		
		return false;
	}	
}