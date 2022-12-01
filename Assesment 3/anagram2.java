import java.util.Scanner;

class anagram2 {
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int tot = 0;
		
		String s1 = s.next(), s2 = s.next();
		
		if(s1.length() != s2.length()) {
			System.out.println("Not anagram");
			return;
		}
		
		for(int i=0 ; i < s1.length() ; i++) 
			tot += s1.charAt(i) - s2.charAt(i);
		
		if(tot == 0) System.out.println("anagram");
		else System.out.println("Not anagram");
	}
}