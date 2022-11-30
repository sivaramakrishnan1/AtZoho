import java.util.Scanner;

class addTwoToDigits { 
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		
		int digit = s.nextInt();
		
		int addedDigit = 0, limit = 1, a;
		
		while(digit > 0)
		{
			a = ((digit % 10) + 2) % 10;
			addedDigit += a * limit;
			digit /= 10;
			limit *= 10;
		}
		
		System.out.println(addedDigit);
	}
}