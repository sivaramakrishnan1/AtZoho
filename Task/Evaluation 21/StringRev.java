import java.util.Scanner;

class StringRev {
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		String str = s.next(), res = "";
		
		int prev = -1;
		
		for(int i = 0 ; i <= str.length() ; i++)
		{
			if(i == str.length() || str.charAt(i) == '.') {
				for(int j = i-1 ; j > prev ; j--)
					res += str.charAt(j) + "";
				if(i != str.length()) res += ".";
				prev = i;
			}
		}
		
		System.out.println(str + "\n" + res);
	}
}