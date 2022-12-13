// problem 7

import java.util.Scanner;

class Combination
{
	static int target;
	static int arr[];
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		arr = new int[]{2, 3, 6, 7};
		target = 8;
		combination(0, 0, "");
		
		s.close();
	}
	
	public static void combination(int start, int sum, String str)
	{
		if(sum == target)
		{
			System.out.println(str);
			sum = 0;
			str = "";
			combination(start + 1, sum, str);
		}
		else if(start < arr.length && sum + arr[start] < target)
		{
			str += arr[start];
			// System.out.println(start + " " + sum + " " + str);
			combination(start, sum + arr[start], str);
			combination(start, sum + arr[start+1], str);
			combination(start + 1, sum, str);
		}
	}
}