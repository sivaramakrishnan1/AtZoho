import java.util.Scanner;

class second
{
	public static void main(String args[])
	{
		int[] arr = new int[26];
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		str = str.toLowerCase();
		
		for(int i=0 ; i < str.length() ; i++)
			if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z')
				arr[str.charAt(i) - 97]++;
			
		int big = 0, sec = -1;
		char bigg = '!', secc = '@';
		
		
		for(int i = 0 ; i < 26 ; i++)
		{
			if(arr[i] > big)
			{
				secc = bigg;
				bigg = (char)(i + 97);
				sec = big;
				big = arr[i];
				// System.out.println((char)(i + 97));
			}
			else if(sec <= arr[i])
			{
				secc = (char)(i + 97);
				sec = arr[i];
				// System.out.println((char)(i + 97));
			}			
		}		
		System.out.println(secc + " : " + sec);
	}
}