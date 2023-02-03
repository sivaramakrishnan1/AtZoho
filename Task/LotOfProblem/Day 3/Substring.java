import java.util.Scanner;

class Substring
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		String str = s.next(), sub = s.next();
		s.close();
		
		for(int i = 0 ; i < str.length() ; i++)
		{
			int j;
			for(j = 0 ; j <= sub.length() && i + sub.length() <= str.length() ; j++)
			{
				if(j == sub.length() || str.charAt(j + i) != sub.charAt(j)) break;
			}
			if(j == sub.length()) {
				System.out.println(i);
				return;
			}
		}
		
		System.out.println(-1);
	}
}