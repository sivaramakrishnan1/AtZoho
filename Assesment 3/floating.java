import java.util.Scanner;

class floating {
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		float num1 = s.nextFloat() , num2 = s.nextFloat();
		
		System.out.printf("%.3f", (num1 + num2));
		s.close();
	}
}