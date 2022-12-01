import java.util.Scanner;

class minIndex
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		String str = s.next() , pat = s.next();
		int min = str.length();
		
		for(int i=0 ; i < pat.length() ; i++)
		{
			for(int j = 0 ; j < min ; j++)
			{
				if(pat.charAt(i) == str.charAt(j))
					min = j;
			}
		}
		
		System.out.println(min);
		s.close();
	}
}