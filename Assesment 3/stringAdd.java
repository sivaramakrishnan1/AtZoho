import java.util.Scanner;

// ! Works only for the row input 3 & 4

class stringAdd
{
	public static void main(String args[]) 
	{
		Scanner s = new Scanner(System.in);
		
		String n1 = s.next(), n2 = s.next();
		int num1 = 0, num2 = 0, lim = 1;
		
		for(int i = n1.length()-1 ; i > -1; i--)
		{
			if(n1.charAt(i) >= '0' && n1.charAt(i) <= '9')
			{
				num1 += (n1.charAt(i) - '0') * lim;
				lim *= 10;
			}
		}
		
		lim = 1;
		for(int i = n2.length()-1 ; i > -1; i--)
		{
			if(n2.charAt(i) >= '0' && n2.charAt(i) <= '9')
			{
				num2 += (n2.charAt(i) - '0') * lim;
				lim *= 10;
			}
		}
		
		System.out.println(num1 + num2);
		s.close();
	}
}