import java.util.Scanner;

class prevUnicodePoint
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		String str = s.next();
		int n = s.nextInt();
		
		if(n-1 > -1 && n < str.length())
			System.out.println(str.codePointAt(n-1));
		else
			System.out.println("Invalid input");
		
		s.close();
	}
}