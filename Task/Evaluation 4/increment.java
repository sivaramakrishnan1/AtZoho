import java.util.Scanner;

class increment
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter a number : ");
		int num1 = s.nextInt();
		
		System.out.println("Incremented number is : " + increase(num1));
		s.close();
	}
	
	public static int increase(int n)
	{
		return ++n;
	}
}