import java.util.Scanner;

class validator {
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		
		String str = s.next();
		
		//checking brackets
		int brackets = 0;
		for(int i=0 ; i < str.length() ; i++)
		{
			if(str.charAt(i) == '(') brackets++;
			if(str.charAt(i) == ')') brackets--;
		}
		
		if(brackets != 0) 
		{
			System.out.println("Invalid");
			return;
		}
		
		// checking operators
		for(int i=0 ; i < str.length() ; i++)
		{
			if(str.charAt(i) == '+' ||str.charAt(i) == '-' ||str.charAt(i) == '*' ||str.charAt(i) == '/' )
			{
				if(i == 0 || i >str.length() -1) 
				{
					System.out.println("Invalid");
					return;
				}
				if(str.charAt(i-1) == ')' && str.charAt(i+1) == '(')
					continue;
				else if(str.charAt(i-1) <= '0' || str.charAt(i-1) <= '9' || str.charAt(i+1) <= '0' || str.charAt(i+1) <= '9')
				{
					System.out.println("Invalid"); 
					return;
				}
			}
		}
		System.out.println("Valid equation");
		
	}
}

		

