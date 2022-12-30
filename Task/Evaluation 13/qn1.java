import java.util.HashMap;
import java.util.Scanner;

class qn1
{
	static long[] arr;
	
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int num = s.nextInt();
		arr = new long[num];
		System.out.println(fib(num));
		s.close();
	}
	
	public static long fib(int n)
	{
		if(n <= 2) return 1;
		else if(arr[n-1] != 0) return arr[n-1];
		else arr[n-1] = fib(n-1) + fib(n-2);
	
		return arr[n-1];
	}
}