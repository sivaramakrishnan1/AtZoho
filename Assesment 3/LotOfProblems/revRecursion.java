import java.util.Scanner;

class revRecursion
{
	static String str = "";
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		str = s.nextLine();
		
		str = recrev(str.length()-1);
		
		System.out.println(str);
		s.close();
	}
	
	public static String recrev(int pos)
	{
		if(pos == 0)
			return str.charAt(0) + "";
		else
			return str.charAt(pos)+(recrev(pos-1));
	}
	
}