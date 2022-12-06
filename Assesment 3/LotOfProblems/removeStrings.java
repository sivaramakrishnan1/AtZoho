import java.util.Scanner;

class removeStrings
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		
		String str = s.nextLine();
		String words[] = {"a", "ac"};
		
		for(int i=0 ; i < words.length ; i++)
		{
			str = str.replaceAll(words[i] , "");
		}
		
		System.out.println(str);
		s.close();
	}
}