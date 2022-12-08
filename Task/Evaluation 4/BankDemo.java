import java.util.Scanner;

class BankDemo
{
	public static void main(String args[]) 
	{
		Scanner s = new Scanner(System.in);
		Bank b = new Bank(1, 2, 3, 4);
		InterestBank ib = new InterestBank(1, 2, 3, 4, 5);
		s.close();
	}
}