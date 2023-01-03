import java.util.Scanner;
class Rat
{
	static int count = 0;
    public static void main(String args[])
    {
		Scanner s = new Scanner(System.in);
		System.out.println("Size: ");
		int m = s.nextInt(), n = s.nextInt();
		
		int[][] arr = new int[m][n];
		
		findPath(arr, 0, 0, "");
		System.out.println("Paths : " + count);
		s.close();
    }
	
	public static void findPath(int[][] arr, int m, int n, String path)
	{
		if(m == arr.length || n == arr[0].length) return;
		if(m == arr.length-1 && n == arr[0].length-1) 
		{
			count++;
			System.out.println(path);
			return;
		}
		
		
		findPath(arr, m+1, n, path + " Down");
		findPath(arr, m, n+1, path + " Right");	
	}
}