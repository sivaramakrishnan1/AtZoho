import java.util.Scanner;

class gcd 
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int first = s.nextInt(), sec = s.nextInt();
		int small = (first < sec) ? first : sec;
		
		while(small > 1)
		{
			if(first % small == 0 && sec % small == 0)
				break;
			else
				small--;
		}
		
		System.out.println(small);
		s.close();
	}
}