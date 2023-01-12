import java.util.Scanner;

class SumOfElements
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter no. of. Test cases : ");
		int T = s.nextInt();
		
		for(int k = 0 ; k < T ; k++)
		{
			System.out.println("row and column : ");
			int row = s.nextInt(), col = s.nextInt();
			int total = 0;
			
			System.out.println("elements : ");
			for(int i = 0 ; i < row ; i++)
				for(int j = 0 ; j < col ; j++)
					total += s.nextInt();
			
			System.out.println("Total : " + total);			
		}
	}
}