import java.util.Scanner;

class PrintMid 
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		String str = s.next();
		
		int printPos = str.length() / 2;
		
		for(int i = 0 ; i < str.length() ; i++)
		{
			int pos = 0;
			for(int j = 0 ; j < str.length(); j++)
			{
				if(j >= str.length() - i - 1) {
					System.out.print(str.charAt((printPos + pos) % str.length()));
					pos++;
				}
				else 
					System.out.print(" ");
			}
			System.out.println();
		}
		
		s.close();
	}
}