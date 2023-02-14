class temp {
	public static void main(String args[])
	{
		int num = 1000;
		
		for(int i = 1000 ; i < 9999 ; i++)
		{
			String val = i + "";
			if(val.equals(rev(i)))
				System.out.println( i + " " + (i * 4) + " " + rev(i));
		}
	}	
	
	static String rev(int i)
	{
		i *= 4;
		
		String num = "";
		
		while(i > 0)
		{
			num += i % 10;
			i /= 10;
		}
		
		return num;
	}
}

