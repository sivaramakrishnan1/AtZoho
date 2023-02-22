import java.util.Scanner;

class Pattern
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		s.close();
		
		for(int i = 0 ; i < n ; i++)
		{
			int val = n;
			for(int j = 0 ; j < n ; j++)
			{
				System.out.print(val + " ");
				if(j < i) val--;
			}
			System.out.println();
		}
	}
}