import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

class Portal implements Serializable
{
	static int tidGen = 100, zidGen = 1000;
	static List<User> accounts = new ArrayList<>();
	static Scanner s = new Scanner(System.in);
	ZEmployee ze;
	
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
	
	public void login() throws UserNotFoundException, PasswordMismatchException
	{
		deserialize();
		
		out : while(true) {
			System.out.println("Welcome, enter \n1. For ZE login\n2. For User login\n3. For User sign-up\n4. Exit");
			
			switch(s.nextInt())
			{
				case 1 : 
				{
					System.out.print("\nEnter your email : ");
					String email = s.next();
					System.out.print("\nEnter your password : ");
					String password = s.next();
					
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
			
			switch(s.nextInt())
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
}