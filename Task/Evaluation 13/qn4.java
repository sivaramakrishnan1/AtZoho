import java.util.Scanner;

class qn4
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
		
		int max = -1, count = 0, sum = 0, maxsum = 0, curr = -1;
		int[] currarr = {} , maxarr = {};
		
		for(int i=0 ; i < size ; i++)
		{
			curr = arr[i];
			sum = curr;
			currarr = addElement(currarr, curr);
			
			for(int j = i+1 ; j < size ; j++)
			{
				if(curr < arr[j])
				{
					count++;
					curr = arr[j];
					sum += curr;
					currarr = addElement(currarr, curr);
				}
			}
			max = (count > max) ? count : max;
			if((sum > maxsum))
			{
				maxsum = sum;
				maxarr = currarr;
			}
			count = 0;
		}
		
		for(int i = 0 ; i < maxarr.length ; i++)
		{
			System.out.print(maxarr[i] + " ");
		}		
		System.out.println("Result : " + (maxsum));
		s.close();
	}
	
	public static int[] addElement(int[] arr, int ele)
	{
		int[] copy = new int[arr.length + 1];
		
		for(int i = 0 ; i < arr.length ; i++)
		{
			copy[i] = arr[i];
		}
		
		copy[arr.length] = ele;
		return copy;
	}
}