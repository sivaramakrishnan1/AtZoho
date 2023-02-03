import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class PasswordValidation
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		String pswd = s.next();
		s.close();
		
		String[] patterns = { "[A-Za-z^[\\D]]*[a-z][A-Za-z0-9]*", "[A-Za-z]*[A-Z][A-Za-z0-9]*",
                "[A-Za-z]*[0-9][A-Za-z0-9]*", ".{6,}", "^[\\D]]*" };
        for (int i = 0; i < patterns.length; i++) {
            Pattern p = Pattern.compile(patterns[i]);
            Matcher m = p.matcher(pswd);
            if (!m.find()) {
                System.out.println("INVALID");
                return;
            }
        }
        System.out.println("VALID");
	}
}