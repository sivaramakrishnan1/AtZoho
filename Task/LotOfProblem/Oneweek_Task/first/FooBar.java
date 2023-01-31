import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

/*
4 word good best word wordgoodgoodgoodbestword
3 bar foo the barfoofoobarthefoobarman
*/


class FooBar
{		
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		FooBar fb = new FooBar();
		
		int size = s.nextInt();
		String[] strs = new String[size];
		
		for(int i = 0 ; i < size; i++)
			strs[i] = s.next();
		
		str = s.next();
		System.out.println(fb.findSubstring(str, strs));
	}
	
	List<Integer> list = new ArrayList<>();
	List<String> values = new ArrayList<>();
	static String str = "";
	
	public void swap(String[] strs, int i, int j)
	{
		String temp = strs[i];
		strs[i] = strs[j];
		strs[j] = temp;
	}
	
	public String toString(String[] strs)
	{
		String res = "";
		
		for(String s : strs)
			res += s;
		
		return res;
	}
	
	public int indexOf(String cmp)
	{
		for(int i = 0 ; i < str.length() ; i++)
		{
			if(str.charAt(i) != cmp.charAt(0))
				continue;
			int pos1 = i + 1, pos2 = 1;
			while(pos1 < str.length() && pos2 < cmp.length() && str.charAt(pos1) == cmp.charAt(pos2))
			{
				pos1++;
				pos2++;
			}
			
			if(pos2 == cmp.length()) return i;
		}
		return -1;
	}
	
	public void permute(String[] strs, int from)
	{
		if(from == strs.length) 
		{
			String put = toString(strs);
			int num = indexOf(put);
			if(num > -1 && !values.contains(put)) {
				list.add(num);
				values.add(put);
			}
			return; 
		}
		
		for(int i = from ; i < strs.length ; i++)
		{
			if(i != from) swap(strs, from, i);
			permute(strs, from+1);
			if(i != from) swap(strs, from, i);
		}
	}
	
	public List findSubstring(String s, String[] strs)
    {
        str = s;
        permute(strs, 0);
        return list;
    }
}