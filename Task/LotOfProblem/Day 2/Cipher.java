import java.util.Scanner;

class Cipher
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		String str = s.nextLine(), res = "";
		int key = s.nextInt();
		s.close();
		
		for(int i = 0 ; i < str.length() ; i++)
		{
			if(str.charAt(i) == ' ') 
				res += " ";
			else 
				res += ((char)(str.charAt(i) + key));
		}
		
		System.out.println(res);
		
		str = "";
		
		for(int i = 0 ; i < res.length() ; i++) 
		{			
			if(res.charAt(i) == ' ') 
				str += " ";
			else 
				str += ((char)(res.charAt(i) - key));
		}
			
		System.out.println(str);
	}
}