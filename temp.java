/**
 * 
 */
import java.util.Scanner;

public class temp {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str = s.next();
		String regex = "[a-zA-Z0-9_+.]*[@]{1}[a-zA-Z0-9]*\\.[a-zA-Z]{2, 5}$";
		System.out.println(str.matches(regex));
		s.close();
	}
}