import java.util.Scanner;

class frequency 
{
	public static void main(String args[]) 
	{
		Scanner s = new Scanner(System.in);
		int num = s.nextInt();
		int[] arr = {0,0,0,0,0,0,0,0,0,0};
		
		while(num > 0)
		{
			arr[num%10]++;
			num /= 10;
		}
		
		for(int i = 0 ; i<10 ; i++)
			System.out.println("Count of " + i + " is " + arr[i]);
		s.close();
	}
}