import java.util.Scanner;

class qn5
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		String str = s.next(), pal = "", curr = "";
		
		for(int i = 1 ; i < str.length() ; i++)
		{
			curr = str.charAt(i) + "";
			for(int j = 1 ; i < str.length() ; j++)
			{
				if(i-j > -1 && i+j < str.length() && str.charAt(i-j) == str.charAt(i+j))
				{
					curr = str.charAt(i-j) + curr + str.charAt(i+j);
				}
				else break;
			}
			pal = (pal.length() < curr.length()) ? curr : pal;
		}
		if(pal.length() > 1)
			System.out.println(pal);
		
		s.close();
	}
}