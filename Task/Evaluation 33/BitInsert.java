import java.util.Scanner;

class BitInsert
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		String byte1 = s.next(), byte2 = s.next(), res = "";
		int end = s.nextInt(), start = s.nextInt();
		
		for(int i = 0 ; i < byte1.length() ; i++)
		{
			if(i == end) {
				res = byte2 + res;
				i += start - end;
			}
			else res = byte1.charAt(byte1.length() - i - 1) + res;
		}
		
		System.out.println(res);
	}
}