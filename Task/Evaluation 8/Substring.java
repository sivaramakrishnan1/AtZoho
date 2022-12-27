import java.util.Scanner;

class Substring
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		
		String str = s.next(), sub = s.next();
		
		if(str.length() < sub.length())
		{
			System.out.println(-1);			
		}
		else {
			for(int i=0 ; i < str.length() - sub.length() + 1 ; i++)
			{
				if(str.charAt(i) == sub.charAt(0))
				{
					int count = 0;
					while(count < sub.length() && (i+count) < str.length() && str.charAt(i+count) == sub.charAt(count))
					{
						count++;
					}
					if(count == sub.length())
					{
						System.out.println("First occurence is: " + (i+1));
						s.close();
						return;
					}
				}
			}
			
			System.out.println("Cant find: " + (-1));
		}
		
		s.close();
		return;
	}
}