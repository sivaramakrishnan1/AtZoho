import java.util.Scanner;

class diffChar {
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		String s1 = s.next(), s2 = s.next(), s3 = "";
		int i=0;
		while(i < s1.length() || i < s2.length())
		{
			if(i < s1.length()) s3 += s1.charAt(i);
			if(i < s2.length()) s3 += s2.charAt(i);
			i++;
		}
		
		for(i=0 ; i < s3.length() ; i++)
		{
			for(int j=0 ; j <= s3.length() ; j++)
			{
				if(j == s3.length())
				{
					System.out.print(s3.charAt(i));
					break;
				}
				if(s3.charAt(i) == s3.charAt(j) && i != j) break;
			}
		}
				
		s.close();
	}
}