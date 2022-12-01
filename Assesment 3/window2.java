import java.util.Scanner;

class window2
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		String str1 = s.next(), str2 = s.next();
		int start = -1, end = str1.length();
		int k=-1, i, j;
		
		for(i=0 ; i<str1.length() ; i++)
		{
			if(str1.charAt(i) != str2.charAt(0)) continue;
			k = 0;
			for(j=i ; j < str1.length() && k < str2.length() ; j++)
			{
				if(str1.charAt(j) == str2.charAt(k)) k++;	
			}
			if(k == str2.length() && (j-i) < (end - start))
			{
				start = i;
				end = j;
			}
		}
		// System.out.println(start + " " + end);

		if(start == -1 || end == str1.length()+1)
		{
			System.out.println("No window");
			return;
		}
		// System.out.println(start + " " + end);
		
		while(start <= end) {
			System.out.print(str1.charAt(start++));
		}			

		s.close();
	}
}