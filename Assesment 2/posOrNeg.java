import java.util.Scanner;

public class posOrNeg {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		
		System.out.print("Enter a value: ");
		int val = s.nextInt();
		
		if(val == 0) System.out.println(val + " is Zero");
		else if(val < 0) System.out.println(val + " is negative");
		else System.out.println(val + " is positive");		
		s.close();
	}
}