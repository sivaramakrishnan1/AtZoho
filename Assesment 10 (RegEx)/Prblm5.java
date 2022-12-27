import java.util.regex.*;
import java.util.Scanner;
class Prblm5
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		Pattern p = Pattern.compile("^[^g].*[^g]$");
		Matcher m = p.matcher(s.next());
		System.out.println(m.matches());
	}
}