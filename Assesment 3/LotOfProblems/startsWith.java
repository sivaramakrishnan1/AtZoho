import java.util.Scanner;

class startsWith
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		String s1 = s.nextLine(), s2 = s.nextLine();
		String start = s.next();
		
		System.out.println(s1 + " starts with " + start + "? : " + s1.startsWith(start));
		System.out.println(s2 + " starts with " + start + "? : " + s2.startsWith(start));
		
		s.close();
	}
}