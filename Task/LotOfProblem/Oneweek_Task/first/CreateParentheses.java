import java.util.*;

class CreateParentheses
{
	int limit;
	List<String> list = new ArrayList<>();
	
	public static void main(String args[])
	{
		CreateParentheses cp = new CreateParentheses();
		Scanner s = new Scanner(System.in);
		cp.limit = s.nextInt();
		s.close();
		
		cp.createParantheses("", 0, 0);
		System.out.println(cp.list);
	}
	
	public void createParantheses(String str, int open, int close)
	{
		if(open == limit && close == limit)
		{
			if(isValid(str))
				list.add(str);
			return;
		}
		
		if(open + 1 <= limit) createParantheses((str + "("), open+1, close);
		if(close + 1 <= limit) createParantheses((str + ")"), open, close+1);
	}
	
	public boolean isValid(String str)
	{
		int count = 0;
		
		for(int i = 0 ; i < str.length() ; i++)
		{
			if(str.charAt(i) == '(') count++;
			else count--;
			
			if(count < 0) return false;
		}
		
		return count == 0;
	}
}