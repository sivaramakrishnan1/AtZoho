import java.util.Scanner;

class ComplexDemo
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		
		Complex c1 = new Complex(5, 5);
		Complex c2 = new Complex(1, 1);
		
		c1.divide(c2);
		System.out.println(c1.toString());
		s.close();
	}
}