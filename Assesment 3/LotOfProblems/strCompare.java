import java.util.Scanner;

class strCompare
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		String s1 = s.next(), s2 = s.next();
		
		if(s1.length() > s2.length()) { System.out.println(s1 + " is greater than " + s2); return;}
		if(s1.length() < s2.length()) { System.out.println(s2 + " is greater than " + s1); return;}

		for(int i=0 ; i < s1.length() ; i++)
		{
			if(s1.charAt(i) != s2.charAt(i))
			{ 
				System.out.println(s1 + " and " + s2 + " are NOT Same"); 
				s.close();
				return;
			}
		}
		System.out.println(s1 + " and " + s2 + " are Same"); 
		s.close();
		}
}