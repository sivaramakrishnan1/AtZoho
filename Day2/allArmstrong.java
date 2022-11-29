import java.util.Scanner;

class allArmstrong 
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int lim = s.nextInt();
		// if(lim > 999) return;
		for(int i = 0 ; i < lim ; i++)
			armstrong(i);
		s.close();
	}
	
	public static void armstrong(int num)
	{	
		int tot = 0, cnum = num;
		while(num > 0)
		{
			int rem = num % 10;
			tot += rem*rem*rem;
			num /= 10;
		}
		if(tot == cnum) System.out.println(tot);
	}	
}