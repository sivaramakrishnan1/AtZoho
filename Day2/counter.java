import java.util.Scanner;


class counter
{
	public static void main(String args[]) 
	{
		Scanner s = new Scanner(System.in);
		int val = s.nextInt();
		int count = 0;
		System.out.print("Count of " + val);
		while(val > 0)
		{
			count++;
			val /= 10;
		}
		System.out.println(" is " + count);
		s.close();
	}
}