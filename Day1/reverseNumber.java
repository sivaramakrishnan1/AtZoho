import java.util.Scanner;

class reverseNumber {
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		
		int digit = s.nextInt();
		
		while(digit > 0)
		{
			System.out.print(digit % 10);
			digit /= 10;
		}
		
		s.close();
	}
}