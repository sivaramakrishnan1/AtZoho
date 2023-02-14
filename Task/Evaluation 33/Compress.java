import java.util.Scanner;

class Compress
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		String str = s.next(), res = "";
		s.close();
		
		for(int i = 0 ; i < str.length() ; i++)
		{
			int count = 0, j = i;
			res += str.charAt(i);
			
			while(j < str.length() && str.charAt(i) == str.charAt(j))
			{
				count++;
				j++;
			}
			
			res += count;
			i = j - 1;
		}
		
		System.out.println(res);
	}
}