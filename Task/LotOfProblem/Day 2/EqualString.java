import java.util.Scanner;

class EqualString
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		String str = s.next();
		s.close();
		
		int star = 0, hash = 0;
		
		for(int i = 0 ; i < str.length() ; i++)
			if(str.charAt(i) == '*') star++;
			else if(str.charAt(i) == '#') hash++;
			
		System.out.println((star == hash) ? "No change" : (star < hash) ? (hash - star) +" extra stars needed" : (star - hash) + " extra hash needed");
		
	}
}