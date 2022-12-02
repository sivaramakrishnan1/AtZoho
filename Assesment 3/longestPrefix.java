import java.util.Scanner;

class longestPrefix {
	public static void main(String args[])
	{
		
		Scanner s = new Scanner(System.in);
		// String[] str = {"geeksforgeeks", "geeks", "geek", "geeker"};
		String[] str = {"Geeks", "Gek"};
		int k = -1;
		for(int i=0 ; i< str.length; i++)
		{
			char ch = str[i].charAt(++k);
			for(int j = 0 ; j < str.length ; j++)
			{
				if(k >= str[j].length() || ch != str[j].charAt(k))
				{
					System.out.println(k);
					s.close();
					return;
				}
			}		
		}
		
		System.out.println(k);
		s.close();
	}
}