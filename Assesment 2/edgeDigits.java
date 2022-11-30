import java.util.Scanner;

class edgeDigits 
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int val = s.nextInt();
		
		if(val < 10) System.out.println("The first and last digits are :" + val);
		
		System.out.println("Last Digit : " + val%10);
		int digit = 0;
		while(val>0){
			digit = val%10;
			val /= 10;
		}
		System.out.println("First Digit : " + digit);
		s.close();
	}
}