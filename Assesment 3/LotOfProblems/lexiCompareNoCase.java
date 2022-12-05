import java.util.Scanner;

class lexiCompareNoCase
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		String s1 = s.next(), s2 = s.next();
		
		if(s1.length() > s2.length()) { System.out.println(s1 + " is greater than " + s2); return;}
		if(s1.length() < s2.length()) { System.out.println(s2 + " is greater than " + s1); return;}

		s1 = smallCase(s1);
		s2 = smallCase(s2);
		
		for(int i=0 ; i < s1.length() ; i++)
		{
			if(s1.charAt(i) > s2.charAt(i))
			{ 
				System.out.println(s1 + " is greater than " + s2); 
				return;
			}
			if(s1.charAt(i) < s2.charAt(i))
			{ 
				System.out.println(s2 + " is greater than " + s1); 
				return;
			}
		}		
		System.out.println(s1 + " and " + s2 + " are lexicographically equal "); 		
		s.close();
	}
	
	public static String smallCase(String str)
	{
		String newstr = "";
		
		for(int i = 0 ; i < str.length() ; i++)
		{
			if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z')
				newstr += (char)(str.charAt(i) - 32);
			else 
				newstr += (char)(str.charAt(i));
		}
		
		return newstr;
	}
}