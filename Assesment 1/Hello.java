import java.util.Scanner;

class Hello
{
	public static void main(String args[])
	{
		String yourName;
		Scanner s = new Scanner(System.in);		
		yourName = s.next();		
		System.out.println("Hi " + yourName + ", hello to you, and your world!");
	}
}