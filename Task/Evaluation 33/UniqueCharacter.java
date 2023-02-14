import java.util.Scanner;

class UniqueCharacter
{
	static int[] alphabets = new int[26];
	
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		s.close();
		
		for(int i = 0 ; i < str.length() ; i++)
		{
			if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z') alphabets[str.charAt(i) - 'a']++;
			else if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') alphabets[str.charAt(i) - 'A']++;
		}
		
		boolean safe = true;
		
		for(int i = 0 ; i < 26 ; i++)
		{
			if(alphabets[i] == 0)
			{
				safe = false;
				System.out.println("String misses character : " + ((char)(i + 'a')));
			}
		}
		
		if(safe) System.out.println("String contains all the characters ");
	}
}