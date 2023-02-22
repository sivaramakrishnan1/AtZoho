import java.util.Scanner;

class SumArrayOpti
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int size = s.nextInt(), before = 0, after = 0;
		int[] arr = new int[size];
		
		for(int i = 0 ; i < size ; i++) {
			arr[i] = s.nextInt();
			before += arr[i];
		}
		
		s.close();
		
		for(int i = arr.length - 1 ; i > -1 ; i--)
		{
			before -= arr[i];
			
			if(before == after) 
			{
				System.out.println(i);
				return;
			}
			
			after += arr[i];
		}
		
		System.out.print(-1);
	}
}