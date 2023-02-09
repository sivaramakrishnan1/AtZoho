import java.util.Scanner;

class Distance
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int[] arr1 = new int[s.nextInt()];
		int[] arr2 = new int[s.nextInt()];
		
		for(int i = 0 ; i < arr1.length ; i++)
		{
			arr1[i] = s.nextInt();
		}
		
		for(int i = 0 ; i < arr2.length ; i++)
		{
			arr2[i] = s.nextInt();
		}
		
		int d = s.nextInt(), j, count = 0;
		
		for(int i = 0 ; i < arr1.length ; i++)
		{
			in : for(j = 0 ; j < arr2.length ; j++)
			{
				if(arr1[i] - arr2[j] <= d && arr2[j] - arr1[i] <= d) break;
			}
			if(j == arr2.length) count++;
		}
		
		System.out.println(count);
	}
}