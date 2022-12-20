import java.util.Scanner;

class SpaceArray
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
			
		int test = s.nextInt();
		
		for(int i = 0 ; i < test ; i++)
		{
			int size = s.nextInt();
			int[] arr = new int[size];
			
			for(int j = 0 ; j < size ; j++)
			{
				arr[j] = s.nextInt();
			}
			
			System.out.println(whoWins(arr));
		}
		
		s.close();
	}
	
	public static String whoWins(int[] arr)
	{
		int n = arr.length, moves = 0;
		
		for(int i = 0 ; i < n ; i++)
		{
			if(arr[i] <= n)
				moves += arr[i] - n;
		}
		
		return (moves % 2 == 0) ? "Second" : "First";
	}
}