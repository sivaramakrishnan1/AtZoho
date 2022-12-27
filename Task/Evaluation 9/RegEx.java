import java.util.Scanner;

class RegEx {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		System.out.println((s.next()).matches(s.next()));
		s.close();
	}
}