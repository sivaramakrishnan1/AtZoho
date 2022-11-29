import java.util.Scanner;

public class typeOfChar {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter a character: ");
		char ch = s.next().charAt(0);
		
		if(ch >= '0' && ch <= '9' ) System.out.println("It is a number");
		else if(ch >= 'a' && ch <= 'z' ) System.out.println("It is a small case letter");
		else if(ch >= 'A' && ch <= 'Z' ) System.out.println("It is a upper case letter");
		else System.out.println("It is a special character");		
		s.close();
	}
}