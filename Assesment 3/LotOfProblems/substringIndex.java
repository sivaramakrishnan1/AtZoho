import java.util.Scanner;

class substringIndex
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		int from = s.nextInt(), to = s.nextInt();
		
		System.out.println("Before: " + str + "\nAfter: " + str.substring(from, to));		
		
		s.close();
	}
}