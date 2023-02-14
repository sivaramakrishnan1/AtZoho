import java.util.*;

class PermutedPallindrome
{
	static Set<String> values = new HashSet<>();
	static boolean found = false;
	
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		String tmp = s.nextLine(), str = "";
		s.close();
		
		for(int i = 0 ; i < tmp.length() ; i++)
		{
			if(tmp.charAt(i) == ' ') continue;
			else if(tmp.charAt(i) >= 'A' && tmp.charAt(i) <= 'Z') str += (char)(tmp.charAt(i) - 'A' + 'a');
			else str += tmp.charAt(i);
		}
		
		permute(str, 0, str.length());
		
		for(String v : values)
			System.out.println(v);
	}
	
	static void permute(String str, int start, int end)
	{
		if(start == end) 
		{
			if(pallindromeCheck(str)) {
				values.add(str);
				found = true;
			}
			return;
		}
		
		if(found) return;
		
		for(int i = start ; i < end ; i++)
		{
			str = swap(str, start, i);
			permute(str, start+1, end);
			str = swap(str, start, i);
		}
	}
	
	static boolean pallindromeCheck(String str)
	{
		int l = 0, r = str.length() - 1;
		
		while(l < r)
		{
			if(str.charAt(l) != str.charAt(r))
				return false;
			l++;
			r--;
		}
		
		return true;
	}
	
	static String swap(String str, int pos1, int pos2)
	{
		String res = "";
		
		for(int i = 0 ; i < str.length() ; i++)
		{
			if(i == pos1) res += str.charAt(pos2);
			else if(i == pos2) res += str.charAt(pos1);
			else res += str.charAt(i);
		}
		
		return res;
	}
	
}