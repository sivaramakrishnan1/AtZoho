import java.util.Scanner;

class substring
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		String str = s.next(), pat = s.next();
		int n = 0;
		
		for(int i=0 ; i < str.length() ; i++)
		{
			if(str.charAt(i) == pat.charAt(0))
				while(i < str.length() && n < pat.length() && str.charAt(i) == pat.charAt(n)) {
					n++; 
					i++;
				}
				if(n == pat.length()-1) 
				{ 
					System.out.println("True"); 
					s.close();
					return;
				}
				else n = 0;
		}
		
		System.out.println("False");
		s.close();
	}
}