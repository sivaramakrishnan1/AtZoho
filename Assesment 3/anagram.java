import java.util.Scanner;

class anagram {
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		String s1 = s.next(), s2 = s.next();
		
		if(s1.length() != s2.length())
		{
			System.out.println("Not anagram");
			return;
		}
		
		char[] c1 = toCharArray(s1), c2 = toCharArray(s2);
		
		for(int i = 0 ; i < c1.length ; i++)
		{
			for(int j = 0 ; j <= c2.length ; j++)
			{
				if(j == c2.length) 
				{
					System.out.println("Not anagram");
					return;
				}
				if(c1[i] == c2[j])
				{
					c2[j] = '~';
					break;
				}
			}
		}
		
		System.out.println("Anagram");
		
		s.close();
	}
	
	public static char[] toCharArray(String str)
	{
		char[] c = new char[str.length()];
		
		for(int i=0 ; i<str.length() ; i++)
			c[i] = str.charAt(i);
		
		return c;
	}
}