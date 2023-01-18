import java.util.Scanner;

class NextBig
{
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		
		for(int t = 0 ; t < T ; t++)
		{
			int size = s.nextInt();
			int arr[] = new int[size];
			int sorted[] = new int[size];
			for(int i = 0 ; i < size ; i++) {
				arr[i] = s.nextInt();
				sorted[i] = arr[i];
			}
			
			sorted = sort(sorted);
		
			for(int i = 0 ; i < size ; i++)
			{
				for(int j = 0 ; j < size ; j++)
				{
					if(j == size-1)
						System.out.print("_ ");
					else if(arr[i] == sorted[j])
					{
						System.out.print(sorted[j+1] + " ");
						break;
					}					
				}
				
			}
			System.out.println();
		}
	}
	
	public static int[] sort(int[] arr)
	{
		for(int i = 0 ; i < arr.length ; i++)
		{
			for(int j = i+1 ; j < arr.length ; j++)
			{
				if(arr[i] > arr[j])
				{
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		
		return arr;
	}
}