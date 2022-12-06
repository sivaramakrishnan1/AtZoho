import java.util.Scanner;

class substring
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		String s1 = s.next(), s2 = s.next();
		
		
		for(int i=0 ; i < s1.length() ; i++)
		{
			if(s1.charAt(i) == s2.charAt(0))
			{				
				int parse = i;
				for(int j=0 ; j <= s2.length() ; j++)
				{
					if(j == s2.length())
					{
						System.out.println("Found substring starting at the position : " + (i+1));
						s.close();
						return;
					}	
					if(s1.charAt(parse) != s2.charAt(j)) break;
					parse++;
				}
			}			
		}
		
		System.out.println(-1);
		s.close();
	}
}