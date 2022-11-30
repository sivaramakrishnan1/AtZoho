import java.util.Scanner;

class swapDigits 
{
	public static void main(String args[]) 
	{
		Scanner s = new Scanner(System.in);
		int val = s.nextInt();
		
		int first = 0 , last = val%10, lim = 1;
		val /= 10;
		
		while(val / lim > 0) lim *= 10;
		
		first = val / (lim / 10);
		
		int res = (val * 10) + first;
		res %= lim;
		res += lim * last;
		
		System.out.println(first + " " + last + " Swapped value: " + res);
		s.close();		
	}
}	