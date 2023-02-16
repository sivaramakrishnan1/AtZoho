import java.util.Scanner;

class AlphaDiff
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		String str = s.next();
		s.close();
		
		
		for(int i = 0 ; i < str.length() - 1 ; i++)
		{
			int first = (str.charAt(i) - str.charAt(i+1) > 0) ? str.charAt(i) - str.charAt(i+1) : str.charAt(i+1) - str.charAt(i);
			int second = (str.charAt(str.length() - i - 1) - str.charAt(str.length() - i - 2) > 0) ? str.charAt(str.length() - i - 1) - str.charAt(str.length() - i - 2) : str.charAt(str.length() - i - 2) - str.charAt(str.length() - i - 1);
			if(first != second) {
				System.out.println("NO");
				return;
			}
		}
		
		System.out.println("YES");
	}
}