import java.util.Scanner;

class Password
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		
		String pass;
		while(true)
		{
			pass = s.nextLine();
			if(pass.equals("-1")) break;
			if(containsSmall(pass) && containsBig(pass) && containsNum(pass) && noSlashes(pass) && noSpaces(pass)) {
				System.out.println("password valid");
				break;
			}
			else 
				System.out.println("password invalid");
		}
		s.close();
	}
	
	public static boolean containsSmall(String str)
	{
		for(int i = 0 ; i < str.length() ; i++)
		{
			if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z') return true;
		}
		return false;
	}
	
	public static boolean containsBig(String str)
	{
		for(int i = 0 ; i < str.length() ; i++)
		{
			if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') return true;
		}
		return false;
	}
	
	public static boolean containsNum(String str)
	{
		for(int i = 0 ; i < str.length() ; i++)
		{
			if(str.charAt(i) >= '0' && str.charAt(i) <= '9') return true;
		}
		return false;
	}
	
	public static boolean noSlashes(String str)
	{
		for(int i = 0 ; i < str.length() ; i++)
		{
			if(str.charAt(i) == '/') return false;
		}
		return true;
	}
	
	public static boolean noSpaces(String str)
	{
		for(int i = 0 ; i < str.length() ; i++)
		{
			if(str.charAt(i) == ' ') return false;
		}
		return true;
	}
}