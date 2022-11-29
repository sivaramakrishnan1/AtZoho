import java.util.Scanner;

class substring
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int start = 0, end = 1, big = 0, count = 0;
		String str = s.next();
		
		while(start < str.length() && end < str.length())
		{
			int cpy = start;
			while(cpy < end && str.charAt(cpy) != str.charAt(end)) 
			{ 
				count++;
				cpy++;
			}
			big = (count > big) ? count : big;
			count = 0;
			if(cpy == end) end++;
			else{
				start = end;
				end++;
			}
		}	
		System.out.println(big+1);		
		s.close();
	}
}