import java.util.Scanner;

class Operations
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		
		int num1 = s.nextInt(), num2 = s.nextInt();
		
		System.out.println("addition addition : " + (num1 + num2));
		System.out.println("subtraction subtraction : " + (num1 + (-1 * num2)));
		System.out.println("multiplic multiplication : " + Omultiply(num1, num2));
		System.out.println("division division : " + division(num1, num2));
		
	}
	
	public static int Omultiply(int num1, int num2)
	{
		int val = num2;
		for(int i = 0 ; i < num1 -1 ; i++)
		{
			num2 += val;
			// System.out.println(num2);
		}
		
		return num2;
	}
	
	public static int division(int num1, int num2)
	{
		int count = -1;
		
		while(num1 > 0)
		{
			num1 -= num2;
			count++;
		}
		
		return count;
	}
}
