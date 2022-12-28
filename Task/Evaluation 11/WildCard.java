import java.util.Scanner;

class WildCard
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		String str = s.next();
		System.out.println(str.matches(s.next()));
		s.close();
	}
}