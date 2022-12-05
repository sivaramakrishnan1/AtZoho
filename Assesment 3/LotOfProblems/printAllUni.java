import java.util.Scanner;

class printAllUni
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		String str = s.next();
		
		System.out.println(str + " have codepoints " + str.codePointCount(0, str.length()));		
		s.close();
	}
}