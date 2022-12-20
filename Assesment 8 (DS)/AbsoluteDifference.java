import java.util.Scanner;
import java.util.HashMap;

class AbsoluteDifference
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
			
		int test = s.nextInt();
		
		for(int i = 0 ; i < test ; i++)
		{
			int size = s.nextInt();
			int[] arr = new int[size];
			
			for(int j = 0 ; j < size ; j++)
				arr[j] = s.nextInt();
			
			System.out.println(count(arr));
		}
		
		s.close();
	}
	
	public static int count(int[] arr)
	{
		if(arr.length == 2) return 0;
		
		HashMap<Integer, Integer> map = new HashMap<>();

			
		for(int i=0 ; i < arr.length; i++)
		{
			if(map.containsKey(arr[i]))
			{
				map.put(arr[i], (map.get(arr[i]))+1);
			}
			else
			{
				map.put(arr[i], 1);
			}
		}
		int bigval = -1;
		
		for(int k : map.values())
		{
			if(k > bigval)
				bigval = k;
		}
		
		return (bigval <= 1) ? arr.length - 2 : arr.length - bigval;			
	}
} 