import java.util.Scanner;
import java.io.*;

class Menu
{	
	static Bank bank = new Bank();
	static Scanner s = new Scanner(System.in);
	
	public static void initialize() throws Exception
	{
		Scanner reader = new Scanner(new File("bank_db.txt"));
		
		if(reader.hasNext()) reader.nextLine();

		while(reader.hasNext()) {
			String str = reader.nextLine();
			bank.initialize(str);
		}
		reader.close();
	}
	
	public static void login() throws Exception
	{
		Menu menu = new Menu();
		Console c = System.console();
		int choice;
		
		loop : while(true) {
			Scanner s = new Scanner(System.in);
			System.out.println("Login\n1. New Account\n2. Existing account");
			choice = s.nextInt();
			
			switch(choice)
			{
				case 1 :
				{
					System.out.println("Enter Account number : ");
					int accntNo = s.nextInt();
					System.out.println("Enter Account holder name : ");
					String name = s.next();
					System.out.println("Enter password");
					String password = s.next();
					System.out.println("Enter password again");
					if(password.equals(s.next()))
					{
						if(bank.addAccount(accntNo, name, password))
							System.out.println("Account created");
						else
							System.out.println("Account not created");
						break;
					}
					System.out.println("Account not created");
					break;
				}
				case 2 :
				{			
					
					System.out.println("User Login\nEnter Account number");
					int id = bank.idOfAccountNumber(s.nextInt()); // getting id of the account number
					
					if(id == -1)
					{
						System.out.println("USER_NOT_FOUND");
						break;
					}
					System.out.print("Enter Password : ");
					String password = String.valueOf(c.readPassword());
					
					if(bank.authenticate(id, password))
					{
						menu.userPage(id);
						break;
					}
					System.out.println("Password incorrect");
					break;
				}
				case 3 :
				{
					s.close();
					break loop;
				}
				default : 
				{
					System.out.println("Invalid input");
				}
			}
		}
	}
	
	public void userPage(int id) throws Exception {
		int choice;

		loop : while(true)
		{
			System.out.println("\nMenu : \n1. Withdrawal\n2. Deposit\n3. Transfer\n4. View balance\n5. Change Password\6. Exit");
			choice = s.nextInt();

			bank.updateToFile();
			
			switch(choice)
			{
				case 1 : {
					System.out.println("Enter amount to withdraw");
					float amount = s.nextFloat();
					bank.withdraw(id, amount);
					break;
				}
				
				case 2 : {
					System.out.println("Enter amount to deposit");
					float amount = s.nextFloat();
					bank.deposit(id, amount);
					break;
				}
				
				case 3 : {
					System.out.println("Enter receiver ID");
					int recId = s.nextInt();
					System.out.println("Enter amount to transfer");
					float amount = s.nextFloat();
					bank.transfer(id, recId, amount);
					break;
				}
				
				case 4 : {
					System.out.println("Balance : " + bank.getBalance(id));
					break;
				}
				case 5 : {
					System.out.println("Enter new Password");
					String password = s.next();
					
					if(password.equals(s.next()))
						bank.setPassword(id, password);
					else
						System.out.println("PasswordMismatch: Password not updated");
					break;
				}
				case 6 : {
					System.out.println("Thank you for banking with us!");
					break loop;
				}
				
				default : {
					System.out.println("Invalid input");
					break;
				}
			}
		}
	}
}