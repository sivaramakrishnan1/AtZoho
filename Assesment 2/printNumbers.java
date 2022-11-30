import java.util.Scanner;

class printNumbers 
{
	public static void main(String args[]) 
	{
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int nn = 1;
		while(nn <= n)
			System.out.println(nn++);
		
		s.close();
	}
}

		