// problem 7

import java.util.Scanner;

class Combination
{
	static int target;
	static int arr[];
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		arr = new int[]{2, 3, 4, 8};
		target = 8;
		combination(0, 0, "");
		s.close();
	}
	
	public static void combination(int start, int sum, String str)
	{
		if(sum == target)
		{
			System.out.println(str);
			return;
		}
		else if(start < arr.length && sum < target)
		{
			combination(start, sum + arr[start], str + arr[start] + " ");
			if(start < arr.length - 1)
				combination(start + 1, sum, str);
		}
	}
}