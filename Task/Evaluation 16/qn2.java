import java.util.Scanner;

class qn2
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter k : ");
		int k = s.nextInt();
		System.out.println("Enter n : ");
		int size = s.nextInt();
		
		System.out.println("Enter array elements : ");
		
		int start = 0, end = size,	 mid = (start + end) / 2, count = 1;
		while(mid > -1 && mid < size)
		{
			mid = (start + end) / 2;
			
			if(mid == k)
			{
				System.out.println("We need " + count + " moves");
				s.close();
				return;
			}
			else if(mid < k)
				end = mid;
			else 
				start = mid;
			count++;
		}
	}
}