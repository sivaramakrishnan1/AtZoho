import java.util.Scanner;

class brackets {
	public static void main(String ars[])
	{
		Scanner s = new Scanner(System.in);
		String str = s.next();
		char[] val = new char[str.length()];
		int lvl = 0;
		
		// if(str.charAt(i) == '{' || str.charAt(i) == '[' ||str.charAt(i) == '(')
		
		for(int i=0 ; i<str.length() ; i++)
		{
			switch(str.charAt(i))
			{
				case '{' : {
					val[lvl++] = '0';
					break;
				}
				case '[' : {
					val[lvl++] = '1';
					break;
				}
				case '(' : {
					val[lvl++] = '2';
					break;
				}
				case '}' : {
					if(val[lvl-1] != '0') {						
						System.out.println("Nope");
						return;
					}
					lvl--;
					break;
				}
				case ']' : {
					if(val[lvl-1] != '1') {
						System.out.println("Nope");
						return;
					}
					lvl--;
					break;
				}
				case ')' : {
					if(val[lvl-1] != '2') {
						System.out.println("Nope");
						return;
					}
					lvl--;
					break;
				}
			}	
		}
		
		System.out.println("Yup");

	}
}