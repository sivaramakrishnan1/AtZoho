import java.util.Scanner;

class operators
{
	public static void main(String args[]) {
		int a, b;
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter two integers");
		a = s.nextInt();
		b = s.nextInt();
		
		System.out.println("\n\na. Addition:\t\t" + a + " + " + b + " = " + (a+b));
		System.out.println("b. Subraction:\t\t" + a + " - " + b + " = " + (a-b));
		System.out.println("c. Multiplication:\t" + a + " * " + b + " = " + (a*b));
		if(b != 0)
			System.out.println("d. Division:\t\t" + a + " / " + b + " = " + (a/b));
		else
			System.out.println("d. Division:\t\t" + a + " / " + b + " = " + "Infinity");
		
		System.out.println("e. Modulus:\t\t" + a + " % " + b + " = " + (a%b)); 
	}
}
