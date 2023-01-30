import java.util.Scanner;

class OddSum
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		int[] arr = new int[size];
		
		for(int i = 0 ; i < size ; i++) arr[i] = s.nextInt();
		
		int sum = 0;
		
		for(int i = 0 ; i < size ; i++)
		{
			if(i > 0 && arr[i] % 2 == 1 && arr[i-1] % 2 == 0) continue;
			sum += arr[i];
		}
		
		System.out.println(sum);
	}
}