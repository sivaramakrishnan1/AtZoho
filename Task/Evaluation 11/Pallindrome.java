import java.util.Scanner;

class Pallindrome
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		String line = s.nextLine();
		// String[] words = split(line);
		String[] words = line.split(" ");
		
		for(String str: words)
		{
			if(!isPallindrome(str)) 
				System.out.print(str + " ");
		}		
	}
	
	public static boolean isPallindrome(String str)
	{
		for(int i=0 ; i< str.length() ; i++)
		{
			if(str.charAt(i) != str.charAt(str.length() -1 - i))
				return false;
		}
		return true;
	}
	
	public static String[] split(String line)
	{
		int count = 0, index = 0, pos = 0;
		
		for(int i=0 ; i < line.length() ; i++)
		{
			if(line.charAt(i) == ' ')
			{
				count++;
			}
		}
		
		String words[] = new String[count+1];
		String str = "";
		
		for(int i=0 ; i < count+1; i++)
		{
			for(int j = index ; j < line.length() ;j++)
			{
				if(line.charAt(index) == ' ')
				{
					words[pos++] = str;
					str = "";
					break;
				}
				str += line.charAt(index++);
			}
			index++;
		}
		words[pos] = str;
		return words;
	}
}