import java.util.Scanner;

public class isVowel {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter a character: ");
		char ch = s.next().charAt(0);
		
		if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' 
		|| ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U' ) System.out.println("It is a vowel");
		else System.out.println("It is a consonant");
		
		s.close();
	}
}