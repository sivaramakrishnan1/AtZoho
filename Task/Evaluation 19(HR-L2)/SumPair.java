import java.util.Scanner;

class SumPair
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		
		String num = s.nextLine();
		int key = s.nextInt();
		s.close();
		
		String[] nums = num.split(" ");
		int[] arr = new int[nums.length];

		for(int i = 0 ; i < arr.length ; i++)
		{
			arr[i] = Integer.parseInt(nums[i]);
		}
		
		arr = removeDuplicate(arr);
		
		String ans = "";
		/* for(int i = 0 ; i < arr.length ; i++)
		{
			System.out.print(arr[i] + " ");
		} */
		
		for(int i = 0 ; i < arr.length ; i++)
		{
			for(int j = i+1 ; j < arr.length ; j++)
			{
				if(arr[i] + arr[j] == key)
				{
					ans += "(" + arr[i] + "," + arr[j] + ")";
				}
			}
		}
		
		if(ans.length() == 0)
			System.out.println("No pair exists for " + key);
		else
			System.out.println(ans);
		
	}
	
	public static int[] removeDuplicate(int[] arr)
	{
		for(int i = 0 ; i < arr.length ; i++)
		{
			for(int j = i-1 ; j > -1 ; j--)
			{
				if(arr[i] == arr[j])
				{
					arr[i] = Integer.MAX_VALUE;
				}
			}
		}
		return arr;
	}
}