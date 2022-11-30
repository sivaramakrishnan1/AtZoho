import java.util.Scanner;

class primeSum {
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt(), sum = 0;
		
		for(int i=2 ; i < n ; i++)
		{
			if(isPrime(i)){
				System.out.print(i + " ");
				sum += i;
			}
		}
		System.out.println("\n" + sum);
		s.close();
	}
	
	public static boolean isPrime(int n)
	{
		double k = 2;
		while(k < n)
		{
			if(n % k == 0) return false;
			k++;
		}
		return true;
	}
}