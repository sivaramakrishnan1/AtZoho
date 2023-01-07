import java.util.Scanner;

class Triplet
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		
		String num = s.nextLine();
		s.close();
		
		String[] nums = num.split(" ");
		int[] arr = new int[nums.length];

		for(int i = 0 ; i < arr.length ; i++)
		{
			arr[i] = Integer.parseInt(nums[i]);
		}
		arr = sort(arr);
		int size = arr.length -1;
		if(arr[size] * arr[size-1] * arr[size-2] < arr[0] * arr[1] * arr[size])
			System.out.println(arr[0] * arr[1] * arr[size] + "\n" + arr[0] + " " + arr[1] + " " + arr[size]);
		else
			System.out.println(arr[size] * arr[size-1] * arr[size-2] + "\n" + arr[size] + " " + arr[size-1] + " " + arr[size-2]);

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