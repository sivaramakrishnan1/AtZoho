import java.util.Scanner;

class Arrange
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		
		System.out.println("Size : ");
		int[] arr = new int[s.nextInt()];
		
		System.out.println("Elements : ");
		for(int i = 0 ; i < arr.length ; i++)
			arr[i] = s.nextInt();
		
		sortArray(arr);
		
		arr.length - 1;
		
		for(int i = 0 ; i < arr.length ; i += 2)
		{
			if(last-1 > -1)
			arr2[i] = arr[last--];
			if(i + 1 < arr.length)
			arr2[i+1] = arr[start++];
		}
		
		for(int i = 0 ; i < arr2.length ; i++)
			System.out.print(arr2[i] + " ");
		
		s.close();
	}
	
	public static void sortArray(int[] arr)
	{
		for(int i = 0 ; i < arr.length - 1 ; i++)
		{
			for(int j = i+1 ; j < arr.length ; j++)
			{
				if(arr[i]> arr[j])
				{
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
}