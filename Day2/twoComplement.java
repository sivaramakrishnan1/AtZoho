import java.util.Scanner;

class twoComplement {
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		String num = s.next();
		int lim = 0;
		String res = "";
		
		while(lim < num.length())
		{
			res += (num.charAt(lim) == '0') ? '1' : '0';
			lim++;
		}
		
		char[] result = toCharArray(res);
		lim--;
		while(lim > -1)
		{
			if(result[lim] == '1') {
				result[lim] = '0';
				lim--;
			}
			else {
				result[lim] = '1';
				break;
			}
		}
		
		System.out.println(toString(result));

		s.close();
	}
	
	public static char[] toCharArray(String s)
	{
		char[] arr = new char[s.length()];
		
		for(int i=0 ; i < arr.length ; i++)
			arr[i] = s.charAt(i);

		return arr;
	}
	
	public static String toString(char[] arr)
	{
		String str = "";
		
		for(char i : arr)
			str += i;
		
		return str;
	}
}