import java.util.Scanner;

class ends
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		String s1 = s.next(), s2 = s.next();
		
		System.out.println("The string " + s1 + " does end with " + s2 + " ? : " + s1.endsWith(s2));
		
		s.close();
		
	}
}