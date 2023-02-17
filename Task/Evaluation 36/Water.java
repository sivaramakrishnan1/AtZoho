import java.util.Scanner;

class Water
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		int[] arr = new int[size];
		
		for(int i = 0 ; i < size; i++)
			arr[i] = s.nextInt();
		s.close();
		
		int max = 0, currmax = 0, highest = 0;
		
		for(int i = 0 ; i < size ; i++)
		{
			if(arr[highest] > arr[i])
				currmax += arr[highest] - arr[i];

			else {
				arr[highest] = arr[i];
				max += currmax;
				currmax = 0;
			}
			System.out.println(i + " " + max + " " + currmax + " " + arr[highest]);
		}
		currmax = 0;
		int revHighest = size-1;
		
		for(int i = size -1 ; i > highest ; i--)
		{
			if(arr[revHighest] > arr[i])
				currmax += arr[revHighest] - arr[i];

			else {
				arr[revHighest] = arr[i];
				max += currmax;
				currmax = 0;
			}
			System.out.println(i + " " + max + " " + currmax + " " + arr[highest]);
		}
		
		System.out.println(max);
	}
}