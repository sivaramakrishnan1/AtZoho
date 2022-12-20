import java.util.Scanner;

class Cells
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
			
		int test = s.nextInt();
		
		for(int i = 0 ; i < test ; i++)
		{
			String str = s.next();
			
			System.out.println(whoWins(str));
		}
		
		s.close();
	}

	public static String whoWins(String str) {
		int Lcount = 0, Rcount = 0, i = 0;
		for(i = 0 ; str.charAt(i) != 'W' ; i++) {
			if(str.charAt(i) == 'B') Lcount++;
		}
		
		for(; i < str.length() ; i++) {
			if(str.charAt(i) == 'B') Rcount++;
		}
		return (Lcount == Rcount) ? "Chef" : "Aleksa";
	}
} 