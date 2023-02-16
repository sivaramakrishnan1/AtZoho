import java.util.Scanner;

class Sort
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		int[] arr = new int[size];
		
		for(int i = 0 ; i < size ; i++)
			arr[i] = s.nextInt();
		s.close();
		
		for(int i = 0 ; i < size - 1 ; i++)
		{
			for(int j = i + 1 ; j < size ; j++)
			{
				if(arr[i] > arr[j])
				{
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		for(int i = 0 ; i < size ; i++)
			System.out.print(arr[i] + " ");
		
	}
}