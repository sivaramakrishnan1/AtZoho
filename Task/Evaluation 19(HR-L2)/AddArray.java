import java.util.Scanner;

class AddArray 
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		/* int size = s.nextInt();
		int[] arr = new int[size];
		
		for(int i = 0 ; i < size ; i++)
		{
			arr[i] = s.nextInt();
		} */
		
		String num = s.nextLine();
		s.close();
		
		String[] nums = num.split(",");
		int[] arr = new int[nums.length];

		for(int i = 0 ; i < arr.length ; i++)
		{
			arr[i] = Integer.parseInt(nums[i]);
		}
		
		for(int i = arr.length - 1 ; i > -1 ; i--)
		{
			if(i == 0 && arr[i] == 9) {
				arr[0] = 0;
				arr = addOne(arr);
				break;
			}
			if(arr[i] != 9)
			{
				arr[i]++;
				break;
			}
			arr[i] = 0;
		}
		
		for(int i = 0 ; i < arr.length ; i++)
		{
			if(i == arr.length - 1) { System.out.print(arr[i]); break; }
			System.out.print(arr[i] + ",");
		}
	}
	
	public static int[] addOne(int[] arr)
	{
		int[] copy = new int[arr.length + 1];
		copy[0] = 1;
		
		for(int i = 0 ; i < arr.length ; i++)
			copy[i+1] = arr[i];
		
		return copy;
	}
}