import java.util.Scanner;

class equation
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		
		System.out.println("Coefficient of x^2");
		int x = s.nextInt();
		
		System.out.println("Constant");
		int con = s.nextInt();
				
		if(con > 0)
		{
			System.out.println("No Real Solution");
			return;
		}
		else if(con == 0 && x > 0)
		{
			System.out.println("Have one solution");
			return;
		}
		else if(con == -1 && x > 0)
		{
			System.out.println("Have more than one solution");
			return;
		}
	}
}