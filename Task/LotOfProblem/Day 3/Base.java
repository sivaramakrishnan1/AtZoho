import java.util.Scanner;

class Base
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		System.out.println("ENter 2 numbers : ");
		int num = s.nextInt() + s.nextInt();
		
		System.out.println("Base : ");
		int base = s.nextInt(), carry = 0, res = 0, power = 0;
		
		while(num > 0 || carry > 0)
		{
			carry = (num % 10) / base;
			res += (num % base) * ((power == 0) ? 1 : power); 
			power = (power == 0) ? 10 : power * 10;
			num /= 10;
			num += carry;
			carry = 0;
		}
		
		System.out.println(res);
	}
}