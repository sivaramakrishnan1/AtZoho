import java.util.Scanner;

class LinearSearch
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		int[] arr = new int[size];
		
		for(int i = 0 ; i < size ; i ++)
			arr[i] = s.nextInt();
		
		int ele = s.nextInt();
		s.close();
		
		System.out.println(getAddress(arr, ele));
	}
	
	static int getAddress(int[] arr, int ele)
	{
		for(int i = 0 ; i < arr.length ; i++)
			if(arr[i] == ele)
				return i;
			
		return -1;
	}
}