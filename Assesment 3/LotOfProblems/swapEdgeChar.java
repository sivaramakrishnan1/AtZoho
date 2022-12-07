import java.util.Scanner;

class swapEdgeChar
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		String s1 = s.nextLine();
		
		String s2 = s1.charAt(s1.length() - 1) + s1.substring(1, s1.length() - 1) + s1.charAt(0);
		System.out.println(s1 + "\n" + s2);
		
		s.close();
		
	}
}