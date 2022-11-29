class lookAndSee
{
	public static void main(String args[]) 
	{
		int val = 10, count = 0;
		String prev = "11", curr = "";
		
		System.out.println(1);
		
		for(int i=0 ; i<val ; i++)
		{
			printString(prev);
			int j=0;
			while(j < prev.length())
			{
				while(j < prev.length()-1 && prev.charAt(j) == prev.charAt(j+1)) 
				{
					count++;
					j++;
				}
				curr += (count+1)+""+ prev.charAt(j);
				count = 0;
				j++;
			}
			prev = curr;
			curr = "";
		}
	}
	
	public static void printString(String str)
	{
		for(int i=0 ; i<str.length() ; i++)
		{
			System.out.print(str.charAt(i) + " ");
		}
		System.out.println();
	}
}			