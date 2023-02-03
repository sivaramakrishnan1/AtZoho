import java.util.Scanner;

class Jar
{
	public static void main(String args[])
	{
		int bal = 10;
		System.out.println("NUMBER OF CANDIES AVAILABLE : " + bal);
		Scanner s = new Scanner(System.in);
		int get = s.nextInt();
		s.close();
		
		if(bal - get < 0)
			System.out.println("INVALID INPUT");
		else {
			bal -= get;
			System.out.println("NUMBER OF ANDIES SOLD : " + get);
		}
				System.out.println("NUMBER OF CANDIES AVAILABLE : " + bal);

	}
}