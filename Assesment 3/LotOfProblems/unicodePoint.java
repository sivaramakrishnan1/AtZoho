import java.util.Scanner;

class unicodePoint
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		String str = s.next();
		int n = s.nextInt();
		
		if(n > -1 && n < str.length())
			System.out.println(str.codePointAt(n));
		else
			System.out.println("Invalid input");
		
		s.close();
	}
}