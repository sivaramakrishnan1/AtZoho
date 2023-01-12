import java.util.Scanner;

class AlternateSort
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		
		System.out.println("No. of test cases : ");
		int T = s.nextInt();
		
		for(int k = 0 ; k < T ; k++)
		{
			System.out.println("Size : ");
			int size = s.nextInt();
			
			int[] arr = new int[size];
			
			System.out.println("elements : ");
			for(int i = 0 ; i < size ; i++)
				arr[i] = s.nextInt();
			int pos = 0;
			
			int[] res = new int[size];
			for(int i = 0 ; i < size ; i++) {
				if(pos < size)
					res[pos++] = arr[size-i-1];
				if(pos < size)
				res[pos++] = arr[i];
			}
			
			for(int i = 0 ; i < size ; i++)
				System.out.print(res[i] + " ");
		}		
	}
}