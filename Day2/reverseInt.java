import java.util.Scanner;

class reverseInt 
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int val = s.nextInt();
		
		while(val > 0) 
		{
			System.out.print(val%10);
			val /= 10;
		}
		
		s.close();
	}
}