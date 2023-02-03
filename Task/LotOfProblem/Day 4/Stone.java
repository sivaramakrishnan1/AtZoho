import java.util.Scanner;

class Stone
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		int[] arr = new int[size];
		
		for(int i = 0 ; i < size ; i++) arr[i] = s.nextInt();
		s.close();
		int len = arr.length;
		
		for(int i = 0 ; i < arr.length-1 ; i++)
		{
			Arrays.sort(arr);
			arr[len - 1] -= arr[len - 2];
			arr[len - 2] = 0;
		}
		
		Arrays.sort(arr);
		System.out.println(arr[len - 1]);	
	}
}