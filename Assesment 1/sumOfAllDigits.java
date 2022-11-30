import java.util.Scanner;

class sumOfAllDigits {
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		String digit = s.next();
		int total = 0;
		if(Integer.valueOf(digit) > 1000) return;
		for(int i = 0 ; i < digit.length() ; i++)
			if(digit.charAt(i)>= '0' && digit.charAt(i) <= '9')
				total += digit.charAt(i) - '0';		
		System.out.println("Sum of all digits for " + digit + " is " + total );
	}
}