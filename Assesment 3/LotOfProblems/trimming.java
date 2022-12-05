import java.util.Scanner;

class trimming
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		System.out.println(str.trim());
		
		s.close();
	}
}