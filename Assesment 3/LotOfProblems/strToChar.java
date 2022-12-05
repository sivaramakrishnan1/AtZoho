import java.util.Scanner;

class strToChar
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		
		String str = s.next();
		char[] arr = str.toCharArray();
		System.out.println("First element from array " + arr[0]);
		
		s.close();
	}
}