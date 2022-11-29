import java.util.Scanner;

class anyNumber
{
	static String str = "";
	public static void main(String args[])
	{
		Scanner s  = new Scanner(System.in);
		
		rec(str);
		s.close();
	}
	
	public static void rec(String str)
	{
		if(str.length() > 3) return;
		rec("3"+str);
		rec("4"+str);
		System.out.println(str);
	}
}