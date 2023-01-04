import java.util.Scanner;

class qn6
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		String str = s.next();
		s.close();
		
		int start = 0, prev = 1, end = str.length() - prev;
		out : while(end > 0)
		{
			start = 0;
			end = str.length() - prev;
			
			while(end > 0 && str.charAt(start) == str.charAt(end))
			{
				start++;
				end--;
				
				if(start <= end)
				{
					break out;
				}
			}
			prev++;
		}
		
		System.out.println(prev-1);
	}
}
