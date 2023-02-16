import java.util.Scanner;

class Distance
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		int[] arr = new int[size];
		for(int i = 0 ; i < size ; i++) arr[i] = s.nextInt();
		s.close();
		
		int min = Integer.MAX_VALUE;
		
		for(int i = 0 ; i < size ; i++)
			for(int j = i - 1 ; j > -1 ; j--)
				if(arr[i] == arr[j]) min = (i - j < min) ? (i - j) : min;
		
		System.out.println((min == Integer.MAX_VALUE) ? -1 : min);
	}
}