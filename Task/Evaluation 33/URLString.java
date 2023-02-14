import java.util.Scanner;

class URLString
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		s.close();
		
		String res = "";
		boolean firstChar = false, nextChar = false;
		
		for(int i = 0 ; i < str.length() ; i++)
		{
			if(str.charAt(i) == ' ') 
			{
				i++;
				nextChar = false;
				while(i < str.length())
				{
					if(str.charAt(i) != ' ') {
						nextChar = true;
						break;
					}
					i++;
				}
				if(nextChar && firstChar) res += "%20";
				if(i >= str.length()) break;
			}
			firstChar = true;
			res += str.charAt(i);				
		}
		
		System.out.println(res);
	}
}