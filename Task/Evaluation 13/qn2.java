import java.util.Scanner;

class qn2
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the size: ");
		int size = s.nextInt();
		System.out.println("Enter the elements: ");
		int[] arr = new int[size];
		
		for(int i=0 ; i < size ; i++)
		{
			arr[i] = s.nextInt();
		}
		
		int max = -1, count = 0, curr = -1;
		for(int i=0 ; i < size ; i++)
		{
			curr = arr[i];
			for(int j = i+1 ; j < size ; j++)
			{
				if(curr < arr[j])
				{
					count++;
					curr = arr[j];
				}
			}
			max = (count > max) ? count : max;
			count = 0;
		}
		
		System.out.println("Result : " + (max+1));
		s.close();
	}
}