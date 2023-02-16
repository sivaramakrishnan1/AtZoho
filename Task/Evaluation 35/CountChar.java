import java.util.Scanner;

class CountChar
{
	static int count = 0;
	
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		String str = s.next();
		int pos = s.nextInt();
		s.close();
		
		for(int i = 0 ; i < pos ; i++)
			if(str.charAt(i % str.length()) == 'a') count++;
		
		System.out.println(count);
		
	}
}