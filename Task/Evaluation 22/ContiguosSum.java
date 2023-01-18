import java.util.Scanner;

class ContiguosSum
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		
		try {
			(Runtime.getRuntime()).exec("mkdir desk");
		} catch(Exception e) {
			System.out.println("This an error");
		}
		while(T > 0)
		{
			int size = s.nextInt();
			int arr[] = new int[size];
			
			for(int i = 0 ; i < size ; i++)
				arr[i] = s.nextInt();
			
			int max = Integer.MIN_VALUE;
			
			for(int i = 0 ; i < size ; i++)
			{
				int currmax = Integer.MIN_VALUE;
				if(arr[i] > max) max = arr[i];
				
				for(int j = i ; j < size ; j++)
				{
					currmax += arr[j];
					if(currmax > max) max = currmax;
				}
			}
			System.out.println(max);
			T--;
		}
	}
}