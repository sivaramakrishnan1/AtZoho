import java.util.Scanner;

class IntCounter {
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		int arr[] = new int[size];
		
		for(int i = 0 ; i < size ; i++)
			arr[i] = s.nextInt();
		
		s.close();
		
		int[] count = new int[size+1];
		
		for(int i = 0 ; i < size ; i++)
		{
			count[arr[i]]++;
		}
		
		for(int i = 0 ; i <= size ; i++)
		{
			if(count[i] != 0)
				System.out.println(i + " appeared " + count[i] + " times.");
			else
				System.out.println(i + " appeared 0 time.");
		}
	}
}