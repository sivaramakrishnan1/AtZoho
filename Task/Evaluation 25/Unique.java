import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class Unique
{	
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		
		int[] arr = new int[size];
		
		for(int i = 0 ; i < arr.length ; i++)
			arr[i] = s.nextInt();
		
		for(int i = 0 ; i < arr.length ; i++)
			getUnique(arr, i+1, arr[i]);
		
	}
	
	public static void getUnique(int[] arr, int pos, int ele)
	{
		if(pos == arr.length) {
			System.out.print(ele + " " );
			return;
		}
		
		if(ele != arr[pos])
			getUnique(arr, pos+1, ele);
	}
	
}

