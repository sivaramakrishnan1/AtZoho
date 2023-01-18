import java.util.Scanner;

class Threshold
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		
		while(T > 0)
		{
			int size = s.nextInt(), thresh = s.nextInt(), count = 0;
			int[] arr = new int[size];
			
			for(int i = 0 ; i < size ; i++) {
				int num = s.nextInt();
				count += (num / thresh) + ((num % thresh != 0) ? 1 : 0);
			}
			
			System.out.println(count);
			T--;
		}
	}

}