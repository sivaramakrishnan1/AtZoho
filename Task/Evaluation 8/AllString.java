import java.util.Scanner;

class AllString
{
	String[] dictionary = {"i", "like", "sam", "sung", "samsung", "mobile", "ice", "icecream", "man", "go", "mango"};

	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		String input = s.next();
		AllString obj = new AllString();
		System.out.println(obj.compareStrings(input));
		s.close();
	}
	
	public boolean compareStrings(String word)
    {
        int size = word.length();
         
        // base case
        if (size == 0)
        return true;
         
        //else check for all words
        for (int i = 1; i <= size; i++)
        {
            if (isIn(dictionary, getSubstring(word,0,i)) && compareStrings(word.substring(i,size)))
				return true;
        }
         
        // if all cases failed then return false
        return false;
    }
	
	public String getSubstring(String str, int start, int end)
	{
		String ret = "";
		if(start > str.length() || end > str.length()) return "";
		for(int i = start ; i < end ; i++) {
			ret += str.charAt(i);
		}
		
		return ret;
	}
	
	public boolean isSame(String s1, String s2)
	{
		if(s1.length() != s2.length()) return false;
		
		for(int i=0 ; i < s1.length() ; i++)
		{
			if(s1.charAt(i) != s2.charAt(i))
				return false;
		}
		
		return true;
	}
	
	public boolean isIn(String[] arr, String str)
	{
		
		for(int i=0 ; i < arr.length ; i++)
		{
			if(isSame(arr[i], str))
				return true;
		}
		
		return false;
	}
}