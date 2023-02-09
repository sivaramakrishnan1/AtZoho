import java.util.Scanner;

class Swap
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		int[] arr = new int[size];
		
		for(int i = 0 ; i < size ; i++)
		{
			arr[i] = s.nextInt();
		}
		
		for(int i = 0 ; i < arr.length ; i+=2)
		{
			if(i+1 >= arr.length) break;
			int temp = arr[i];
			arr[i] = arr[i+1];
			arr[i+1] = temp;
		}
		
		for(int i = 0 ; i < size ; i++)
		{
			System.out.print(arr[i] + " ");
		}
	}
}