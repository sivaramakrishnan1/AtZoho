import java.util.Scanner;

class numpad
{
	public static void main(String args[])
	{
		int[] num = {2, 22, 222, 3, 33, 333, 4, 44, 444, 5, 55, 555, 6, 66, 666, 7, 77, 777, 7777, 8, 88, 888, 9, 99, 999, 9999};
		
		Scanner s = new Scanner(System.in);
		String str = s.next();
		String numstr = "";
		
		
		for(int i = 0 ; i < str.length() ; i++)
			numstr += num[str.charAt(i) - 65];
		
		System.out.println(numstr);
	}
}