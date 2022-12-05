class indexAll
{
	public static void main(String args[])
	{
		String str = "The quick brown fox jumps over the lazy dog";
		char[] arr = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
		
		for(int i=0 ; i < arr.length ; i++)
			System.out.println(arr[i] + " - " + str.indexOf(arr[i]));
	}
}