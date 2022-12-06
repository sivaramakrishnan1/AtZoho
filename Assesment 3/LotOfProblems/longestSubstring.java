import java.util.Scanner;

// Spent nearly 3 hours for this problem

class longestSubstring {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        String str = s.next(), bigs = "";
        int big = -1, parse = 0;
		
		for(int i = 0 ; i < str.length() ; i++)
		{
			outer: for(int j = i+1 ; j < str.length(); j++)
			{
				for(int k = i; k < j ; k++)
				{
					if(str.charAt(k) == str.charAt(j))
					{
						break outer;
					}
				}
				big = (j-i+1 > big) ? j-i : big;
				bigs = (j-i+1 > bigs.length() ) ? str.substring(i, j+1) : bigs;
			}
		}
		
        System.out.println(bigs + " length : " + big);
    }
}