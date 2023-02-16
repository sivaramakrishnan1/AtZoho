import java.util.Scanner;

class SearchString
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		String[] arr = (s.nextLine()).split(" ");
		String ele = s.next();
		s.close();
		// for(int i = 0 ; i < arr.length ; i++) System.out.println(i + " " + arr[i]);
		System.out.println(getAddress(arr, ele));
	}
	
	static int getAddress(String[] arr, String ele)
	{
		for(int i = 0 ; i < arr.length ; i++) if(arr[i].equals(ele)) return i;
		return -1;
	}
}