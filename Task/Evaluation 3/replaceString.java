import java.util.Scanner;

class replaceString
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		
		String str = s.nextLine(), rep = s.next(), repstr = s.next(), newstr = "";
		
		int pos = substring(str, rep);
		System.out.println(pos);
		
		
		for(int i=0 ; i<str.length() ; i++)
		{
			if(i == pos) 
			{
				for(int j=0 ; j<repstr.length() ; j++)
				{
					newstr += repstr.charAt(j);
				}
				i += rep.length();
			}
			newstr += str.charAt(i);
		}

		System.out.println(newstr);
	}
	
	public static int substring(String s1, String s2)
	{
		for(int i=0 ; i < s1.length() ; i++)
		{
			if(s1.charAt(i) == s2.charAt(0))
			{				
				int parse = i;
				for(int j=0 ; j <= s2.length() ; j++)
				{
					if(j == s2.length())
					{
						return i;
					}	
					if(s1.charAt(parse) != s2.charAt(j)) break;
					parse++;
				}
			}			
		}
		
		return -1;
	}
}