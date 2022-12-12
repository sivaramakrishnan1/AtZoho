import java.util.Scanner;

class BankMain
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		
		SavingsAccount dadsSavings = new SavingsAccount((float)0.3), s1;
		CheckingAccount kidsChecking = new CheckingAccount(), c1;
		BankAccount b;
		/*
		dadsSavings.deposit(10000);
		System.out.println("Dad's: " + dadsSavings.getBalance() + "\nKid's: " + kidsChecking.getBalance());
		
		dadsSavings.transferMoney(kidsChecking, 3000);
		System.out.println("Dad's: " + dadsSavings.getBalance() + "\nKid's: " + kidsChecking.getBalance());
		
		kidsChecking.withdraw(200);
		System.out.println("Dad's: " + dadsSavings.getBalance() + "\nKid's: " + kidsChecking.getBalance());
		
		kidsChecking.withdraw(400);
		System.out.println("Dad's: " + dadsSavings.getBalance() + "\nKid's: " + kidsChecking.getBalance());
		
		kidsChecking.withdraw(300);
		System.out.println("Dad's: " + dadsSavings.getBalance() + "\nKid's: " + kidsChecking.getBalance());
		
		kidsChecking.withdraw(500);
		System.out.println("Dad's: " + dadsSavings.getBalance() + "\nKid's: " + kidsChecking.getBalance());
		
		kidsChecking.withdraw(400);
		System.out.println("Dad's: " + dadsSavings.getBalance() + "\nKid's: " + kidsChecking.getBalance());
		
		dadsSavings.addCompoundInterest();
		kidsChecking.chargeFees();
		System.out.println("Dad's: " + dadsSavings.getBalance() + "\nKid's: " + kidsChecking.getBalance());
		 */
		
		boolean loop = true;
		
		while(loop)
		{
			System.out.println("Choose \n\t1. dadsSavings \n\t2. kidsChecking ");
			int accChoice = s.nextInt();
			
			if(accChoice != 1 && accChoice != 2) break;
			
			inloop : while(true) 
			{
				System.out.println("Menu \n\t1. Check Balance \n\t2. Withdraw \n\t3. Deposit \n\t4. Transfer \n\t5. End of period \n\t6. Exit");
				int choice = s.nextInt();
			
				switch(choice)
				{
					case 1: 
					{
						if(accChoice == 1) 
							dadsSavings.display();
						else 
							kidsChecking.display();
						break;
					}
					
					case 2: 
					{
						System.out.println("Enter amount to withdraw: ");
						if(accChoice == 1) 
							dadsSavings.withdraw(s.nextFloat());
						else 
							kidsChecking.withdraw(s.nextFloat());
						break;
					}
					
					case 3: 
					{
						System.out.println("Enter amount to deposit: ");
						if(accChoice == 1) 
							dadsSavings.deposit(s.nextFloat());
						else 
							kidsChecking.deposit(s.nextFloat());
						break;
					}
					
					case 4:
					{
						System.out.println("Enter amount to transfer: ");
						if(accChoice == 1) 
							dadsSavings.transferMoney(kidsChecking, s.nextFloat());
						else 
							kidsChecking.transferMoney(dadsSavings, s.nextFloat());
						break;
					}
					
					case 5:
					{
						System.out.println("Period ends!!! ");
						if(accChoice == 1) 
							dadsSavings.addCompoundInterest();
						else 
							kidsChecking.chargeFees();
						break;
					}
					
					case 6:
					{
						System.out.println("Exited");
						break inloop;
					}
					
					default:
					{
						System.out.println("Incorrect choice");
					}
				}
			}
		}
			
		s.close();
	}
}