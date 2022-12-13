import java.util.Scanner;

class Sum
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		int[] nums = new int[size];
		
		for(int i = 0 ; i < size ; i++)
		{
			nums[i] = s.nextInt();
		}
		
		int total = s.nextInt();
		
		for(int i = 0 ; i < size ; i++)
		{
			for(int j = i+1 ; j < size ; j++)
			{
				if(nums[i] + nums[j] == total)
				{
					System.out.println("Found: " + (i+1) + " " + (j+1));
					s.close();
					return;
				}
			}
		}		
		
		s.close();
	}
}