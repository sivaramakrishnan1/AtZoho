import java.util.Scanner;

class Window
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Size : ");
		int size = s.nextInt();
		System.out.println("Elements : ");
		int[] arr = new int[size];
		
		for(int i = 0 ; i < size ; i++) arr[i] = s.nextInt();
		
		System.out.println("Window size : ");
		int win = s.nextInt();
		int max = 0;
		s.close();
		
		for(int i = 0 ; i < size ; i++)
		{
			int sum = 0;
			
			for(int j = i ; j < i + win && j < size; j++)
			{
				sum += arr[j];
			}
			if(max < sum) max = sum;
		}
		
		System.out.println(max);
	}
}