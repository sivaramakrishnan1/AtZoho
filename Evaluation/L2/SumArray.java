import java.util.Scanner;

class SumArray
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		int[] arr = new int[size];
		
		for(int i = 0 ; i < size ; i++)
			arr[i] = s.nextInt();
		s.close();
		
		for(int i = 0 ; i < size ; i++)
		{
			int before = 0, after = 0;
			
			for(int j = 0 ; j < i ; j++)
				before += arr[j];
			
			for(int j = i + 1 ; j < size ; j++)
				after += arr[j];
			
			if(before == after)
			{
				System.out.print(i);
				return;
			}
		}
		
		System.out.print(-1);
	}
}