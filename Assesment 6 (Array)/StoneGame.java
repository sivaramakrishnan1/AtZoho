import java.util.Scanner;

class StoneGame
{
	public static void main(String a[])
	{
		Scanner s = new Scanner(System.in);
		System.out.println(s.nextInt() % 4 != 0);
		s.close();
	}
}