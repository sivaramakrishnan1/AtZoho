import java.util.Scanner;

class tables 
{
	public static void main(String args[]) 
	{
		Scanner s = new Scanner(System.in);
		int val = s.nextInt();
		
		for(int i = 1 ; i < 11 ; i++)
		{
			System.out.println( val + " x " + i + " = " + (val*i));
		}
		s.close();
	}
}	