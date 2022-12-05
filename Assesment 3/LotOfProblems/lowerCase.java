import java.util.Scanner;

class lowerCase
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		String str = s.next();
		System.out.println(str.toLowerCase());
		
		s.close();
	}
}