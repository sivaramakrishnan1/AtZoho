import java.util.Scanner;

public class greater {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		
		System.out.print("Enter two numbers: ");
		int a = s.nextInt();
		int b = s.nextInt();
		
		if(a > b) System.out.println(a + " is greater than " + b);
		else System.out.println(b + " is greater than " + a);
	}
}