import java.util.Scanner;

class strEquals
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		String s1 = s.next(), s2 = s.next();
		
		System.out.println(s1 + " equals " + s2 + " : " + s1.equals(s2));
		s.close();
	}
}