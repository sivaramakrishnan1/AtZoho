import java.util.Scanner;


class BaseAdd
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int num1 = s.nextInt(), num2 = s.nextInt();
		int carry = 0, base = s.nextInt();
		int res = 0, limit = 1;
		
		while(num1 > 0 || num2 > 0)
		{			
			int d1 = num1 % 10, d2 = num2 % 10;
			int temp = (d1 + d2 + carry) % base;
			res += temp * limit;
			limit *= 10;
			carry = (d1 + d2 + carry) / base;
			num1 /= 10;
			num2 /= 10;
			System.out.println(d1 + " " + d2 + " " + limit + " " + carry + " " + res);
		}
		res += carry * limit;
		System.out.println(res);
	}
}