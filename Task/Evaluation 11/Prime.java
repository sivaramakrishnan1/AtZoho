import java.util.Scanner;

class Prime
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		
		int num = s.nextInt();
		
		for(int i = 2 ; i < num ; i++)
		{
			if(isPrime(i) && isPrime(num - i)) {
				System.out.println(i + " " + (num - i));
				break;
			}
		}
		s.close();
	}
	
	public static boolean isPrime(int n)
	{
		for(int i = 0 ; i < (n/2)+1 ; i++)
		{
			for(int j = 0 ; j < (n/2)+1 ; j++)
				if(i*j == n) return false;
		}
		
		return true;
	}
}
		