import java.util.Scanner;

class oneComplement {
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		String num = s.next();
		int lim = 0;
		String res = "";
		
		while(lim < num.length())
		{
			res += (num.charAt(lim) == '0') ? '1' : '0';
			lim++;
		}		
		System.out.println(res);
		s.close();
	}
}