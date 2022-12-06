import java.util.Scanner;

class maxoccurence
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		int arr[] = new int[26];
		str = lowercase(str);

		
		for(int i=0 ; i<str.length() ; i++)
		{
			if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z')
				arr[str.charAt(i)-'a']++;
		}
		
		char maxc = ' ';
		int max = -1;
		
		for(int i=0 ; i < arr.length ; i++)
		{
			if(arr[i] > max) {
				max = arr[i];
				maxc = (char)(i + 'a');
			}
		}
		
		System.out.println(maxc + " appeared " + max + " times.");
		s.close();		
	}
	
	public static String lowercase(String str)
	{
		String newstr = "";
		
		for(int i = 0 ; i < str.length() ; i++)
		{
			if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z')
			{
				newstr += (char)(str.charAt(i) - ('a' - 'A'));
			}
			else 
				newstr += str.charAt(i);
		}
		
		return newstr;
	}
}