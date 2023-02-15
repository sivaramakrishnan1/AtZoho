import java.util.Scanner;

class Robot
{
	boolean foundPath = false;
	
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		int[][] arr = new int[size][size];
		
		int obstacles = s.nextInt();
		for(int i = 0 ; i < obstacles ; i++)
		{
			int x = s.nextInt(), y = s.nextInt();
			if(x > -1 && x < arr.length && y > -1 && y < arr.length)
			{
				arr[x][y] = 1;
			}
		}
		s.close();
		
		Robot obj = new Robot();
		obj.countWays(arr, 0, 0, "");
	}
	
	void countWays(int[][] arr, int x, int y, String path)
	{
		if(foundPath) return;
 		if(x == arr.length-1 && y == arr.length-1)
		{
			foundPath = true;
			System.out.println(path + " Got there !");
			return;
		}
		
		if(x < 0 || y < 0 || x >= arr.length || y >= arr.length) return;
		
		if(x + 1 < arr.length && arr[x+1][y] != 1) countWays(arr, x+1, y, path + "(" + (x+1) + " " + y + ") -> ");
		if(y + 1 < arr.length && arr[x][y+1] != 1) countWays(arr, x, y+1, path + "(" + x + " " + (y+1) + ") -> ");
	}
	
}