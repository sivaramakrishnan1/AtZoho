import java.util.Scanner;

class dupCharsStrings
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		String s1 = s.nextLine(), s2 = s.nextLine(), res = "";
		
		
		for(int i=0 ; i<s1.length() ; i++)
		{
			if(s2.indexOf(s1.charAt(i)) < 0)
			{
				res += s1.charAt(i);
			}
		}
		
		System.out.println(res);
		
		s.close();
	}
}