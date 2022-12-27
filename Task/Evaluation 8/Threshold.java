import java.util.Scanner;

class Threshold
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int size = s.nextInt(), bigcount = 0;
		int[] arr = new int[size];
		
		for(int i=0 ; i < size ; i++)
		{
			arr[i] = s.nextInt();
		}
		
		int thresh = s.nextInt();
		
		for(int i = 0 ; i < size ; i++) {
			int count = 1, num = arr[i];
			
			while(num > thresh)
			{
				count++;
				num -= thresh;
			}
			System.out.println(arr[i] + " : " + count);
			bigcount += count;
		}
		
		System.out.println("Parts: " + bigcount);
		s.close();
		return;
	}
}