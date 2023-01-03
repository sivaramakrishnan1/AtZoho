import java.util.Scanner;

class Subset
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		
		int size = s.nextInt();
		
		int[] arr = new int[size];
		boolean[] barr = new boolean[size];
		
		for(int i = 0 ; i < arr.length ; i++)
		{
			arr[i] = s.nextInt();
			barr[i] = true;
		}
		
		int val = s.nextInt();
		
		isSubset((val *-1), arr, barr);
	}
	
	public static boolean isSubset(int val, int[] arr, boolean[] barr)
	{
		if(val == 0) {
			System.out.println("Subset found");
			for(int j = 0 ; j < arr.length ; j++)
			{
				if(barr[j] == false)
				{
					System.out.print(arr[j] + " ");
				}
			}
			return true;
		}
		
		for(int i = 0 ; i < arr.length ; i++)
		{
			if(arr[i] != 0 && barr[i]) {
				barr[i] = false;
				if(isSubset(val + arr[i], arr, barr))
					return true;
				barr[i] = true;
			}
		}
		return false;
	}
}