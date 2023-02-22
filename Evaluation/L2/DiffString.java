import java.util.Scanner;

class DiffString
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		String str1 = s.next(), str2 = s.next();
		s.close();
		
		for(int i = 0 ; i < str1.length() ; i++)
		{
			String diff1 = "", diff2 = "";
			
			while(i < str1.length() && str1.charAt(i) != str2.charAt(i))
			{
				diff1 += str1.charAt(i);
				diff2 += str2.charAt(i);
				i++;
			}
			if(!diff1.equals(""))
			{
				System.out.println(diff1 + " , " + diff2);
			}
		}
		
	}
}