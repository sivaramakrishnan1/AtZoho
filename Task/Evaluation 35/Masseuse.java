import java.util.Scanner;

class Masseuse
{
	int max = 0;
	
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		int[] arr = new int[size];
		
		for(int i = 0 ; i < size ; i++)
			arr[i] = s.nextInt();
		s.close();
		
		Masseuse mass = new Masseuse();
		mass.massage(arr, 0, 0);
		
		System.out.println(mass.max);
	}
	
	void massage(int[] arr, int pos, int val)
	{		
		for(int i = pos; i < arr.length ; i++) massage(arr, i+2, val + arr[i]);
		if(max < val) max = val;
	}
}