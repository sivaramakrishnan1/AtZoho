import java.util.Scanner;

class concat
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		String s1 = s.next(), s2 = s.next();
		
		System.out.println(s1 + " " + s2);
		s.close();
	}
}