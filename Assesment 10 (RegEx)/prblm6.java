import java.util.Scanner;
import java.util.regex.*;

class prblm6
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		String str = s.next();
		Pattern p = Pattern.compile("[a-zA-Z0-9_]+");
		Matcher m = p.matcher(str);
		System.out.println(m.matches());
	}
}