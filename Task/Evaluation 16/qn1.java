import java.util.Scanner;

class qn1
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter size : ");
		int size = s.nextInt();
		int arr[] = new int[size];
		
		System.out.println("Enter array elements : ");
		for(int i = 0 ; i < size ; i++)
		{
			arr[i] = s.nextInt();
		}
		
		int start = -1, end = -1, max = Integer.MIN_VALUE;
		
		for(int i = 0 ; i < size - 1 ; i++)
		{
			
			int j = i+1, currmax = arr[i];
			while(j < size)
			{
				currmax *= arr[j];
				
				if(currmax > max)
				{
					start = i;
					end = j;
					max = currmax;
				}
				j++;
			}
		}
		
		if(start != -1)
		{
			for(int i = start ; i <= end ; i++)
				System.out.print(arr[i] + " ");
		}
		System.out.println("From " + start + " to " + end + " gives : " + max);
		
	}
}