import java.util.Scanner;

class NextGreat
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		int[] arr = new int[size];
		
		for(int i = 0 ; i < size ; i++) 
			arr[i] = s.nextInt();
		
		for(int i = 0 ; i < size-1 ; i++)
		{
			int min = Integer.MAX_VALUE;
			for(int j = i+1 ; j < size ; j++)
			{
				if(arr[i] < arr[j] && arr[j] < min)
					min = arr[j];
			}
			
			if(min == Integer.MAX_VALUE) System.out.print(-1 + " ");
			else System.out.print(min + " ");
		}
		System.out.print(-1 + " ");
		s.close();
	}
}