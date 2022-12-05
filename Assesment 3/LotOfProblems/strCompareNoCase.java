import java.util.Scanner;

class strCompareNoCase
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		String str1 = s.next(), str2 = s.next();
		
		if(str1.length() > str2.length()) { System.out.println(str1 + " is greater than " + str2); return;}
		if(str1.length() < str2.length()) { System.out.println(str2 + " is greater than " + str1); return;}

		StringBuffer s1 = new StringBuffer(str1);
		StringBuffer s2 = new StringBuffer(str2);
		
		
		System.out.println(str1 + " and " + str2 + " : " + s1.toString().equals(s2.toString())); 
		s.close();
	}
	
	public static StringBuffer smallCase(StringBuffer str)
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