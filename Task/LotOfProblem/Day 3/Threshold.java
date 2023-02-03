import java.util.Scanner;

class Threshold
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
		int thresh = s.nextInt(), count = 0;
		
		s.close();
		
		for(int i = 0 ; i < size ; i++)
		{
			count += arr[i] / thresh;
			count += (arr[i] % thresh != 0) ? 1 : 0;
		}
		
		System.out.println(count);
	}
}