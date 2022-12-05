import java.util.Scanner;

class ending
{
	public static void main(String args[])
	{
		String s = "Checking the endsWith() function";
		Scanner sc = new Scanner(System.in);
		String pat = sc.next();
		
		System.out.println("Does the string \"" + s + "\" ends with " + pat + " : " + s.endsWith(pat));
		sc.close();
	}
}