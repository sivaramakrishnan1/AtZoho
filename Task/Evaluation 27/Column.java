import java.util.Scanner;

class Column
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		String str = s.next();
		s.close();
		
		int sum = 0, power = 0;
		
		for(int i = str.length() - 1 ; i > -1 ; i--)
			sum += (Math.pow(26, power++)) * (str.charAt(i) - 'A' + 1);

		
		System.out.println(sum);
	}
}