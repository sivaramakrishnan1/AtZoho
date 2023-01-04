class qn5
{
	static int max = 0;
	public static void main(String args[])
	{
		int arr = {6, 1, 4, 2, 5, 3};
		System.out.println(find(arr, 0, 0))
	}
	
	public static int find(int[] arr, int pos, int val)
	{
		if(pos >= arr.length - 1)
			return 0;
		
		for(int  i = pos+1 ; i < arr.length - 1 ; i++)
		{
			if(arr[pos] < arr[i])
				val += find(arr, i+1);
		}
	}
}