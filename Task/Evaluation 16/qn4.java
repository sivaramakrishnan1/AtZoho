import java.util.Scanner;

class qn4
{
	public static void main(String a[])
	{
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter size : ");
		int size = s.nextInt();
		String arr[] = new String[size];
		
		System.out.println("Enter array elements : ");
		for(int i = 0 ; i < size ; i++)
		{
			arr[i] = s.next();
		}
		
		System.out.println("Enter your string : ");
		String str = s.next();
		s.close();
		
		for(int i = 0 ; i < str.length() ; i++)
		{
			for(int j = 0 ; j < str.length() ; j++)
			{
				String ele = substring(str, i, j);
				
				if(contains(ele, arr))
				{
					System.out.print(ele + " ");
				}
			}
		}
	}
	
	public static String substring(String str, int start, int end)
	{
		String copy = "";
		
		for(int i = start ; i <= end ; i++)
		{
			copy += str.charAt(i);
		}
		
		return copy;
	}
	
	public static boolean contains(String str, String[] arr)
	{
		for(String s : arr)
			if(s.equals(str))
				return true;
		
		return false;
	}
}