import java.util.Scanner;

class PermutedString
{
	public static void main(String a[])
	{
		Scanner s = new Scanner(System.in);
		String str1 = s.next(), str2 = s.next();
		s.close();
		
		PermutedString ps = new PermutedString();
		System.out.println(ps.isPermutedString(str1, str2));
	}
	
	boolean isPermutedString(String str1, String str2)
	{
		if(str1.length() != str2.length()) return false;
		
		int val = 0;
		
		for(int i = 0 ; i < str1.length() ; i++)
		{
			val ^= str1.charAt(i);
			val ^= str2.charAt(i);
		}
		
		return val == 0;
	}
}