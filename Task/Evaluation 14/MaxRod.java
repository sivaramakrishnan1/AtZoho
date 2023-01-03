import java.util.Scanner;

class MaxRod
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Size: ");
		int size = s.nextInt();
		int max = -1;
		int[] arr = new int[size];
		String cuts = "";
		
		for(int i=0 ; i<size ; i++)
		{
			arr[i] = s.nextInt();
			if(arr[i] > max) 
			{
				max = arr[i];
				cuts = "" + arr[i];
			}			
		}
		
		for(int i=0 ; i<size ; i++)
		{
			for(int j=0 ; j<size ; j++)
			{
				if(arr[i] + arr[j] > max && (i+j) < size - 1)
				{
					max = arr[i] + arr[j];
					cuts = arr[i] + " " + arr[j];
				}
			}
		}
		
		System.out.println("Cuts : " + cuts + " = " + max);		
	}
}