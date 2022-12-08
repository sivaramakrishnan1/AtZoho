import java.util.Scanner;

class frequency
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int arr[] = new int[27];
		String str = s.nextLine();
		
		str = lowerCase(str);
		
		for(int i=0 ; i < str.length() ; i++)
		{
			if(i != 0 && str.charAt(i) == ' ' && str.charAt(i-1) != ' ')
				arr[26]++;
			
			if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z')
				arr[str.charAt(i) - 'a']++;
		}
		
		System.out.println("No. of words : " + (arr[26]+1));
		
		for(int i=0 ; i < 26 ; i++)
		{
			if(arr[i] != 0)
			System.out.println("Frequency of character \'" + ((char)(i+'a')) + "\' is : " + arr[i]);
		}
		
	}
	
	public static String lowerCase(String str) {
		String newstr = "";

		for(int i=0 ; i < str.length() ; i++)
		{
			if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z')
			{
				newstr += (char)(str.charAt(i) + 32);
			}
			else 
				newstr += str.charAt(i);
		}
		return newstr;
	}
}