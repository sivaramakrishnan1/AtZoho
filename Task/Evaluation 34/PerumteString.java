import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

class PerumteString
{
	Set<String> set = new HashSet<>();
	
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		String str = s.next();
		s.close();
		
		PerumteString ps = new PerumteString();
		ps.permute(str, 0, str.length() -1);
		
		for(String string : ps.set) System.out.println(string);
	}
	
	void permute(String str, int start, int end)
	{
		if(start == end) 
		{
			set.add(str);
			return;
		}
		
		for(int i = start ; i <= end ; i++)
		{
			str = swap(str, start, i);
			permute(str, start+1, end);
			str = swap(str, start, i);
		}		
	}
	
	String swap(String str, int from, int to)
	{
		String res = "";
		
		for(int i = 0 ; i < str.length() ; i++)
		{
			if(i == from) res += str.charAt(to);
			else if(i == to) res += str.charAt(from);
			else res += str.charAt(i);
		}
		
		return res;
	}
}