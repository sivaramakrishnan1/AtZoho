import java.util.Scanner;

class LexiSort
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		String[] arr = new String[size];
		
		for(int i = 0 ; i < size ; i++) arr[i] = s.next();
		
		for(int i = 0 ; i < size - 1 ; i++)
		{
			for(int j = i + 1 ; j < size ; j++)
			{
				if(arr[i].compareTo(arr[j]) > 0)
				{
					String temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		
		for(int i = 0 ; i < size ; i++)
		System.out.print(arr[i] + " ");	
		
	}
	
	/* {
		int max = -1;
		
		for(int i = 0 ; i < size ; i++)
		{
			max = ((arr[i] + "").length() > max) ? (arr[i] + "").length() : max;
		}
		
		int[] copy = new int[size];
		for(int i = 0 ; i < size ; i++)
		{
			copy[i] = arr[i];
			if(copy[i] < 0)
			{
				while((copy[i] + "").length() < max)
				{
					copy[i] *= -10;
				}
			}
			else
				while((copy[i] + "").length() < max)
				{
					copy[i] *= 10;
				}
		}
		for(int i = 0 ; i < size ; i++)
			System.out.print(copy[i] + " ");
		System.out.println();
		
		for(int i = 0 ; i < size - 1 ; i++)
		{
			for(int j = i + 1 ; j < size ; j++)
			{
				if(copy[i] > copy[j])
				{
					int temp = copy[i];
					copy[i] = copy[j];
					copy[j] = temp;
					
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		
		for(int i = 0 ; i < size ; i++)
			System.out.print(arr[i] + " ");
	} */
}