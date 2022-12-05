import java.util.Scanner;

class replaceString
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		String str = "The quick fox jumps over a lazy dog";
		System.out.println(str);
		String strrep = s.next();
		System.out.println(str.replace("dog", strrep));	
		
		s.close();
	}
}