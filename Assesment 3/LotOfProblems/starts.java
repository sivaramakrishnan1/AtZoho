import java.util.Scanner;

class starts
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		String s1 = s.next();
		
		if(s1.startsWith("black")) System.out.println("black");
		else if(s1.startsWith("red")) System.out.println("red");		
		s.close();
		
	}
}