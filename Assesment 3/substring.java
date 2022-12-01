import java.util.Scanner;

class substring
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		String str1 = s.next(), str2 = s.next();
		System.out.println(str1 + str2);
		System.out.println(strstr(str1, str2));
		
		s.close();
	}
	
	public static int strstr(String str1, String str2)
	{
		if(str1.length() < str2.length()) return -1;
		
		for(int i=0 ; i < str1.length() ; i++)
		{
			if(str1.length() - i < str2.length()) break;
			if(str1.charAt(i) != str2.charAt(0)) continue;
			int k = i;
			for(int j=0 ; j <= str2.length() ; j++)
			{				
				if(j == str2.length()) return i;
				
				if(str1.charAt(k) != str2.charAt(j)) break;
				
				k++;
			}
		}
		return -1;
	}
}