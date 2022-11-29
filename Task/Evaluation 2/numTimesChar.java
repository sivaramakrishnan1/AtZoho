import java.util.Scanner;

class numTimesChar
{
	public static void main(String args[])
	{
		Scanner s  = new Scanner(System.in);
		String str = s.next();
		char c;
		
		for(int i = 1 ; i < str.length() ; i++)
		{
			c = str.charAt(i-1);
			int num = 0, lim = 1;
			while(i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <='9')
			{
				num += (str.charAt(i) - '0') * lim;
				lim *= 10;
				i++;
			}			
			for(int j=0 ; j<num ; j++)
				System.out.print(c);
		}		
		s.close();
	}
}