import java.util.Scanner;

class window
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		String str1 = s.next(), str2 = s.next();
		
		int start = -1, end = str1.length();
		int cur1 = start+1, cur2 = end-1;
		
		while(cur1 < str1.length() && cur2 > -1)	
		{
			if(str1.charAt(cur1) == str2.charAt(0) )
				if(cur1 > end) 
					break;
				else
					start = cur1;
			if(str1.charAt(cur2) == str2.charAt(str2.length() - 1))
				end = cur2;
			cur1++;
			cur2--;
		}
		
		if(start == -1 || end == str1.length())
		{
			System.out.println("No window");
			return;
		}			
		
		// System.out.println(start + " " + end);
		int k = 1, i = start;
		
		while(i < end)
		{
			if(str1.charAt(++i) == str2.charAt(k)) k++;
			i++;
		}
		// System.out.println(i + " " + end);
		
		if(i != end+1)
		{
			System.out.println("No window");
			return;
		}
		for(i = start ; i <= end ; i++)
			System.out.print(str1.charAt(i));
		
		s.close();
		
	}
}	