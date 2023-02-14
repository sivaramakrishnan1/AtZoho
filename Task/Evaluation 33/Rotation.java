import java.util.Scanner;

class Rotation
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		String str1 = s.next(), str2 = s.next();
		s.close();
		Rotation obj = new Rotation();
		
		System.out.println(obj.isRotativeSubstring(str1, str2));
			
	}
	
	boolean isRotativeSubstring(String str1, String str2)
	{
		if(str1.length() != str2.length()) return false;
		
		
		for(int i = 0 ; i < str1.length(); i++)
		{
			if(str1.charAt(0) == str2.charAt(i))
			{
				int pos = 0;
				while(pos < str1.length())
					if(str1.charAt(pos) == str2.charAt((pos + i) % (str1.length()))) pos++;
					else break;
					
				if(pos == str1.length()) return true;
			}
		}
		
		return false;
	}
}