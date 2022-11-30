import java.util.Scanner;

class printRevNumbers 
{
	public static void main(String args[]) 
	{
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		while(0 < n)
			System.out.println(n--);
		
		s.close();
	}
}

		