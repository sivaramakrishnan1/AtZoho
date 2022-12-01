import java.util.Scanner;

class cycleString 
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		
		String s1 = s.next(), s2 = s.next();
		
		int shift = 2;
		
		for(int i = 0; i < s1.length() ; i++)
		{
			if(s1.charAt((i+shift)%s1.length()) != s2.charAt(i))
			{
				System.out.println("Nope");
				return;
			}
		}
		
		System.out.println("Yup");
		s.close();
	}
}