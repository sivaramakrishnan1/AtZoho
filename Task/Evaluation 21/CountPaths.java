import java.util.Scanner;

class CountPaths
{
	long count = 0;
	int r, c;
	
	public static void main(String args[])
	{
		CountPaths cp = new CountPaths();
		Scanner s = new Scanner(System.in);
		cp.r = s.nextInt() - 1;
		cp.c = s.nextInt() - 1;
		s.close();
		
		// arr = new String[row][col];
		
		/* for(int i = 0 ; i < row ; i++)
		{
			for(int j = 0 ; j < col ; j++)
			{
				arr[i][j] = ((char)('A' + count++)) + " ";
				// System.out.println(arr[i][j]);
			}
		} */
		long firstTime = System.currentTimeMillis();
		cp.counter(0, 0);
		long end = System.currentTimeMillis();
		System.out.println(cp.count);
		System.out.println(end - firstTime);
	}
	
	/* public static void counter(int row, int col, String path)
	{
		if(row == arr.length - 1 && col == arr[0].length -1)
		{
			count++;
			System.out.println(path);
			return;
		}
		
		if(row < arr.length-1)
			counter(row + 1, col, path + arr[row+1][col]);
		if(col < arr[0].length-1)
			counter(row, col+1, path + arr[row][col+1]);
	} */
	
	public void counter(int row, int col)
	{
		if(row > r || col > c) return;

		if(row == r && col == c)
		{
			count++;
			return;
		}
		
		
		counter(row + 1, col);
		counter(row, col+1);
	}
}