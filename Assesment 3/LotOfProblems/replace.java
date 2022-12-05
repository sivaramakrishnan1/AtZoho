import java.util.Scanner;

class replace
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		String s1 = s.next();
		char replacing = s.next().charAt(0), replaceTo = s.next().charAt(0);
		
		System.out.println(s1 + "\n" + s1.replace(replacing, replaceTo));	
		
		s.close();
	}
}