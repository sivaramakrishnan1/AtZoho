import java.util.Scanner;

class DupArray
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		int[] arr = new int[size];
		
		for(int i=0 ; i < size ; i++)
			arr[i] = s.nextInt();
		
		for(int i=0 ; i < size -1 ; i++)
		{
			if(arr[i] == arr[i+1])
			{
				arr[i] *= 2;
				arr[i+1] = 0;
			}
		}
		
		int zeroCount = 0;
		
		for(int i=0 ; i < size ; i++)
		{
			if(arr[i] == 0)
			{
				zeroCount++;
				continue;
			}
			else
			{
				System.out.print(arr[i]+ " ");
			}
		}
		
		for(int i=0 ; i < zeroCount ; i++){
			System.out.print("0 ");
		}
	}
}