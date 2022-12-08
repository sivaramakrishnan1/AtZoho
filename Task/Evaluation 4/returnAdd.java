import java.util.Scanner;

class returnAdd
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter two numbers : ");
		int num1 = s.nextInt(), num2 = s.nextInt();
		
		System.out.println("Addition of those two numbers are  : " + addition(num1, num2));
		s.close();
	}
	
	public static int addition(int n1, int n2)
	{
		return n1+n2;
	}
}