import java.util.Scanner;

class equalLengthSubstring
{
	public static void main(String main[])
	{
		Scanner s = new Scanner(System.in);
		
		String s1 = s.next(), s2 = s.next();
		
		if(s1.length() > s2.length())
			s1 = cut(s1, ( s1.length() - s2.length() ) , s1.length());
		else if(s1. length() < s2.length())
			s2 = cut(s2, ( s2.length() - s1.length() ) , s2.length());
		
		System.out.println(s1+s2);
		s.close();
	}
	
	public static String cut(String str, int start, int end) { 
		return str.substring(start, end);
	}
}