import java.util.Scanner;

class stringRotation
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		String str = s.next();
		String rot = s.next();		
		
		str += str;
		
		System.out.println(str.indexOf(rot) > -1);
		
		s.close();
	}
}		