import java.util.Scanner;

class containsAllChars
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int size = s.nextInt(), j;
		String strs[] = new String[size];
		
		for(int i = 0 ; i < size ; i++)
		{
			strs[i] = s.next();
		}	
		
		String cont = s.next();		
		
		for(int i = 0 ; i < strs.length ; i++)
		{
			for(j = 0 ; j < cont.length() ; j++)
			{				
				if(j == cont.length() -1 && strs[i].indexOf(cont.charAt(j)) > -1)
					System.out.println(strs[i]); 
				else if(strs[i].indexOf(cont.charAt(j)) < 0)
					break;
			}
		}			
				
		s.close();
	}
}