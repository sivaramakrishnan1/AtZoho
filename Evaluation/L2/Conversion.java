import java.util.Scanner;

class Conversion
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		long num = s.nextLong(), base = s.nextInt();
		s.close();
		
		if(base > 20) {
			System.out.println("Invalid input. Enter base value less than or equal 20");
			return;
		}
		char[] values = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K'};
		String res = "";
		
		while(num > 0)
		{
			res = values[(int)(num % base)] + res;
			num /= base;
		}
		
		System.out.println(res);
		
	}
}