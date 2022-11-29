class spiral 
{
	public static void main(String args[])
	{
		int val = 4;
		
		for(int i=1 ; i<= val*2 ; i++)
		{
			for(int j = 1 ; j <= val ; j++)
			{
				if(i == 1 || i == val*2) System.out.print(0);
				else System.out.print(val - j - i);
			}
			System.out.println();
		}
	}
}