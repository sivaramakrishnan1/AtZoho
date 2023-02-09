import java.util.Scanner;

class Pattern
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		String str = s.next(), pat = s.next();
		
		s.close();
		
		for(int i = 0 ; i <= pat.length() ; i++)
		{
			if(i == pat.length()){
				System.out.println(str.equals(pat));
				return;
			}
			else if(pat.charAt(i) == '*') {
				System.out.println(matchAny(str, pat, i+1));
				return;
			}
			else if(pat.charAt(i) == '?') {
				System.out.println(matchSingle(str, pat));
				return;
			}
		}
	}
	
	public static boolean matchAny(String str, String pat, int pos)
	{
		if(pat.length() == 1) return true;
		int spos = 0;
		
		while(pos < pat.length() && spos < str.length())
		{
			if(str.charAt(spos) == pat.charAt(pos))
			{
				pos++;
			}
			spos++;
			
		}
		
		return pos == pat.length();
	}
	
	public static boolean matchSingle(String str, String pat)
	{
		if(str.length() != pat.length()) return false;
		
		for(int i = 0 ; i < str.length() ; i++)
		{
			if(pat.charAt(i) != '?' && str.charAt(i) != pat.charAt(i)) return false;
		}
		
		return true;
	}
	
}