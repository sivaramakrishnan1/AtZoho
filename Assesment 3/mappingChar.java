import java.util.Scanner;
import java.util.HashMap;

class mappingChar
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		
		String s1 = s.next(), s2 = s.next();
		
		if(s1.length() != s2.length())
		{
			System.out.println("Not isomorphic");
			return;
		}
		HashMap<Character, Character> map = new HashMap<>();
		
		for(int i=0 ; i<s1.length() ; i++)
		{
			if(map.containsKey(s1.charAt(i)))
			{
				if(map.get(s1.charAt(i)) != s2.charAt(i))
				{
					System.out.println("Not isomorphic");
					return;
				}
			} else {
				map.put(s1.charAt(i), s2.charAt(i));
			}
		}		
		System.out.println("Isomorphic");
	}
}