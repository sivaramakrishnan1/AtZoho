import java.util.Scanner;

class CountAndSay
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int limit = s.nextInt();
		s.close();
		CountAndSay cas = new CountAndSay();
		
		System.out.println(cas.countAndSay(limit));
	}
	
	public String countAndSay(int n) 
	{
        String str = "1", newstr = "";
		
		for(int i = 1 ; i < n ; i++)
		{
			newstr = "";			
			int pos = 0, count = 0;
			
			for(int j = 0 ; j <= str.length() ; j++)
			{
				if(j < str.length() && str.charAt(j) == str.charAt(pos))
					count++;
				else {
					newstr += "" + count + str.charAt(pos);
					pos = j;
					count = 1;
				}				
			}			
			str = newstr;
		}		
		
		return str;
    }
}