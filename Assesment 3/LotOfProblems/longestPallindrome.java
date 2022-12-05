import java.util.Scanner;

class longestPallindrome
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		String bigString = "";
		
		for(int i=0 ; i < str.length() ; i++)
		{
			for(int j = str.length() - 1 ; j > i ; j--)
			{
				if(str.charAt(i) == str.charAt(j))
				{
					int m = j, k = i;
					while(m > -1 && k < str.length() && k <= m && str.charAt(k) == str.charAt(m))
					{
						// System.out.println(str.charAt(k) + " " + str.charAt(m) + i + j);
						m--; 
						k++;
					}
					if(k >= m && bigString.length() < (j - i)) 
						bigString = str.substring(i, j+1);
				}
			}
		}
		System.out.println(bigString);
		s.close();
	}
}