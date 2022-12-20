import java.util.Scanner;
import java.util.LinkedList;
import java.util.Arrays;

class NBonacci
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
			
		int test = s.nextInt();
		
		for(int i = 0 ; i < test ; i++)
		{
			int n = s.nextInt();
			int q = s.nextInt();
			
			int[] arr = new int[n];
			
			for(int j = 0 ; j < n ; j++) {
				arr[j] = s.nextInt();
			}
			
			for(int j = 0 ; j < q ; j++) {
				System.out.println(calculate(arr, s.nextInt() + 1, n, q));
			}
			
		}
		
		s.close();
	}
	
	public static int calculate(int[] ser, int q, int n, int m)
	{
		LinkedList<Integer> series = new LinkedList<>();
		
		for(int i: ser)
			series.add(i);
		if(q < series.size()) return series.get(q);
		
		for(int i = n ; i < q ; i++)
		{
			int sum = 0;
			for(int j = 0 ; j < n ; j++)
				sum ^= series.get(i-j-1);
			
			series.add(sum);
			System.out.println(series);
		}
		
		return series.getLast();
	}
}