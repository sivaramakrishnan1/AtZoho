import java.util.Scanner;

class Pattern
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int mid = n / 2;
		int[] arr = new int[n];
		int[] newarr = new int[n];
		arr[n-1] = 1;
		
		for(int j = 0 ; j < n ; j++) {
			if(arr[j] == 0)
				System.out.print(" ");
			else 
				System.out.print(arr[j]);
		}
		System.out.println();
		for(int i = 0 ; i < n-1 ; i++) {
			for(int j = 0 ; j < n ; j++) {
				if(j == n-1) newarr[j] = arr[j];
				else newarr[j] = arr[j] + arr[j+1];				
			}
			
			for(int j = 0 ; j < n ; j++) {
				if(newarr[j] != 0)
					System.out.print(newarr[j] + " ");
				else 
					System.out.print(" ");
			}
			arr = newarr;
			newarr = new int[n];
			System.out.println();
		}
	}
}