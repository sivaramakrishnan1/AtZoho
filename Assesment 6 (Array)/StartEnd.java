// problem 6

import java.util.Scanner;

class StartEnd
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int[] arr = new int[s.nextInt()];
		int tar = s.nextInt(), start = -1, end = -1;
		
		for(int i = 0 ; i < arr.length ; i++)
		{
			arr[i] = s.nextInt();
		}
		
		for(int i = 0 ; i < arr.length ; i++)
		{
			if(arr[i] == tar)
			{
				if(start == -1) start = i;
				else end = i;
			}
		}
		
		System.out.println(start + " " + end);
		s.close();
	}
}