import java.util.Scanner;


class shortRepeat
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		String str = s.next();
		
		int ins = str.length();
		
		for(int i = 0 ; i < str.length() ; i++)
		{
			for(int j = i+1 ; j < str.length() ; j++)
			{
				if(str.charAt(i) == str.charAt(j))
				{
					ins = (ins > j) ? j : ins;
					break;
				}					
			}
		}
		
		System.out.println("Duplicate position:" +(ins+1) + " Duplicate character:" + str.charAt(ins));
	}
}