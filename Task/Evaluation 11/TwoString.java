import java.util.Scanner;

class TwoString
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		
		String str1 = s.next(), str2 = s.next();
		
		str2 = reverse(str2);
		
		// System.out.println(str2);
		
		
		s.close();
	}
	
	public static String reverse(String str)
	{
		String rev = "";
		
		for(int i=str.length()-1 ; i > -1 ; i--)
		{
			rev += str.charAt(i);
		}
		
		return rev;
	}
}