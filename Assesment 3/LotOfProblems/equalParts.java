import java.util.Scanner;

class equalParts
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		String str = s.next();
		int n = s.nextInt();
		int eq = str.length() / n;
		
		for(int i=0 ; i < str.length() ; i++)
		{
			if(i % eq == 0)
				System.out.println();
			System.out.print(str.charAt(i));
		}
		s.close();
	}
}