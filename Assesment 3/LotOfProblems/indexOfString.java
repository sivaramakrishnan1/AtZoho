import java.util.Scanner;

class indexOfString
{
	public static void main(String main[])
	{
		Scanner s = new Scanner(System.in);
		
		String str = s.nextLine();

		
		System.out.println("Does the string \"" + str + "\" starts with good : " + (str.indexOf("good") == 0));
		s.close();
	}
}