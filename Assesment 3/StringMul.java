import java.util.Scanner;


class StringMul
{
	public static void main(String args[]) 
	{
		Scanner s = new Scanner(System.in);
		
		String str1 = s.next(), str2 = s.next();
		int tot = 0,  lim = 1;
		/*
		double val	= (new Integer(str1)) * (new Integer(str2));
		System.out.println(val);
		*/
		long val1 = 0, val2 = 0;
		
		for(int i=str1.length()-1 ; i > -1 ; i--)
		{
			val1 += (str1.charAt(i) - '0') * lim;
			lim *= 10;
		}
		lim = 1;
		
		for(int i = str2.length() - 1 ; i > -1 ; i--)
		{
			val2 += (str2.charAt(i) - '0') * lim;
			lim *= 10;
		}
		
		System.out.println(val1 * val2);
	}	
}