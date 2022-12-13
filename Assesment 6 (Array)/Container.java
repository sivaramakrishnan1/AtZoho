import java.util.Scanner;

class Container
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		
		int[] arr = new int[s.nextInt()];
		
		for(int i = 0 ; i < arr.length ; i++)
			arr[i] = s.nextInt();
		
		int big = 0, h;
		
		for(int i = 0 ; i < arr.length - 1 ; i++)
			for(int j = i + 1 ; j < arr.length ; j++)
			{
				if(arr[i] < arr[j]) h = arr[i];
				else h = arr[j];
				
				if(big < (h * (j - i)))
					big = h * (j - i);
			}
		
		System.out.println(big);
		
		s.close();
	}
}