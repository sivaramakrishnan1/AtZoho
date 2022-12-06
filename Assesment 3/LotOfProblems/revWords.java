import java.util.Scanner;

class revWords
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		String str = s.nextLine(), res = "";
		int prev = -1;
		
		for(int i = 0 ; i < str.length() ; i++) {
			if(str.charAt(i) == ' ' || i == str.length() - 1) {				
				for(int j = i ; j > -1 && j > prev ; j--) {
					if(str.charAt(j) != ' ')
					res += str.charAt(j);
				}
				res += " ";
				prev = i;
			}
		}
		System.out.println(res);
		s.close();
	}
}