import java.util.Scanner;

class DualSort
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		
		String num = s.nextLine();
		s.close();
		
		String[] nums = num.split(",");
		int[] arr = new int[nums.length];

		for(int i = 0 ; i < arr.length ; i++)
		{
			arr[i] = Integer.parseInt(nums[i]);
		}
		
		arr = sort(arr);
		
		if(arr.length % 2 == 1)
			for(int i = 0 ; i <= (arr.length / 2) ; i++)
			{
				if(i < arr.length / 2)
					System.out.print(arr[i] + "," + arr[arr.length - i - 1] + ",");
				else
					System.out.print(arr[i]);
			}
		else
			for(int i = 0 ; i < (arr.length / 2) ; i++)
			{
				System.out.print(arr[i] + "," + arr[arr.length - i - 1] + ",");
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