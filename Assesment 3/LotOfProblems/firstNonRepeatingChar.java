import java.util.Scanner;

class firstNonRepeatingChar
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		
		String str = s.next(), newstr = "";
		
		for(int i = 0 ; i < str.length() ; i++)
		{
			if(str.lastIndexOf(str.charAt(i)) == str.indexOf(str.charAt(i)))
			{
				System.out.println("Found " + str.charAt(i) + " at " + i);
				s.close();
				return;
			}
		}
		
		System.out.println("Found nothing");
		s.close();
	}
}
