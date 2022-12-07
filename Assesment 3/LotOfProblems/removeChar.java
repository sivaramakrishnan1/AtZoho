import java.util.Scanner;

class removeChar
{
	public static void main(String main[])
	{
		Scanner s = new Scanner(System.in);
		
		String s1 = s.next();
		int pos = s.nextInt();
		
		StringBuffer sb = new StringBuffer(s1);
		
		System.out.println(sb.deleteCharAt(pos));
		s.close();
	}
}