class bytes
{
	public static void main(String args[])
	{
		String str = "A new Morning";
		byte[]	bytes = str.getBytes();
		
		for(byte b : bytes)
		{
			System.out.print(b + "\t");
		}
		System.out.println();
		for(byte b : bytes)
		{
			System.out.print((char)b + "\t");
		}
	}
}