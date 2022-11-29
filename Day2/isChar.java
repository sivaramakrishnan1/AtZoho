import java.util.Scanner;

public class isChar {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter a character: ");
		char ch = s.next().charAt(0);
		
		if(ch <= '0' && ch >= '9') System.out.println("It is a number");
		else System.out.println("It is a character");
		
		s.close();
	}
}