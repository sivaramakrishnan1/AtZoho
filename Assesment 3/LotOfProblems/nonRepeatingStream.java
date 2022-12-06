import java.util.Scanner;

class nonRepeatingStream
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		
		String str = s.nextLine();
		
		for(int i=0 ; i < str.length() ; i++)
		{
			for(int j = 0 ; j < str.length() ; j++)
			{
				if(str.charAt(i) != str.charAt(j))
				{
					System.out.println("Reading: " + str.charAt(j) + "\nThe first non-repeating character so far is: " + str.charAt(i));
				}
			}
		}
		
		s.close();
	}
}