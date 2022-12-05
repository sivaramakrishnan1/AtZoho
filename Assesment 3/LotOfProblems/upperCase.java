import java.util.Scanner;

class upperCase
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		String str = s.next();
		System.out.println(str.toUpperCase());
		
		s.close();
	}
}