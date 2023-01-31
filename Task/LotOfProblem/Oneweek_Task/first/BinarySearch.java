import java.util.Scanner;

class BinarySearch
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		
		int[] arr = new int[size];
		for(int i = 0 ; i < size ; i++)
		{
			arr[i] = s.nextInt();
		}
		
		int ele = s.nextInt();
		
		s.close();
		
		BinarySearch bs = new BinarySearch();
		System.out.println(bs.findEle(arr, ele));
		
	}
	
	public int findEle(int[] arr, int ele)
	{
		int l = 0, r = arr.length - 1, mid = (r - (r - l) / 2);
		
		while(l <= r)
		{
			if(arr[mid] == ele) return mid;
			else if(arr[mid] < ele) l = mid+1;
			else r = mid-1;
			
			mid = (r - (r - l) / 2);
		}
		
		return -1;
	}
}