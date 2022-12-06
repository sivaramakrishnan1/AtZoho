import java.util.Scanner;

class countPrintDups
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
		
		for(int i=0 ; i < arr.length ; i++)
		{
			if(arr[i] > 1) {
				System.out.println((char)(i + 'a') + " appeared " + arr[i] + " times.");
			}
		}
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