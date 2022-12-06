import java.util.Scanner;

class removedups
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		
		String str = s.next(), newstr = "";
		
		for(int i = 0 ; i < str.length() ; i++)
		{
			if(str.indexOf(str.charAt(i)) == i)
			{
				newstr += str.charAt(i);
			}
		}
		
		System.out.println(newstr);
	}
}
