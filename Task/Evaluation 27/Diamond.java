import java.util.Scanner;

/* 
5
0 1 0 -1 1
1 1 1 0 -1
1 -1 1 1 1
0 1 1 0 1
-1 0 -1 1 1 
*/

class Diamond
{
	static int down = 0, up = 0;
	static int[][] aftermath;
	
	public static void main(String args[])
	{
		Diamond d = new Diamond();
		
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		
		int[][] cave = new int[size][size];
		
		for(int i = 0 ; i < size ; i++)
		{
			for(int j = 0 ; j < size ; j++)
			{
				cave[i][j] = s.nextInt();
			}
		}
		
		d.toBottom(cave, 0, 0, 0);		
		// d.toTop(aftermath, size-1, size-1, 0);
		
		
		System.out.println(down+up);
		
		/* for(int i = 0 ; i < size ; i++)
		{
			for(int j = 0 ; j < size ; j++)
			{
				System.out.print(aftermath[i][j] + "\t");
			}
			System.out.println();
		} */
	}
	
	public void toBottom(int[][] c, int i, int j, int val)
	{
		int[][] cave = copy(c);
		
		if(i == cave.length-1 && i == j)
		{
			toTop(cave, cave.length-1, cave.length-1, val);
			return;
		}
		
		if(i >= cave.length || j >= cave.length) return;
			
		if(cave[i][j] == -1) return;
		if(cave[i][j] > 0) val += cave[i][j];
		cave[i][j] = 0;
		
		toBottom(cave, i+1, j, val);
		toBottom(cave, i, j+1, val);
	}
	
	public void toTop(int[][] c, int i, int j, int val)
	{
		int[][] cave = copy(c);
		
		if(i == 0 && j == 0)
		{
			if(val > up)
				up = val;
			return;
		}
		
		if(i < 0 || j < 0) return;
		
		
		
		if(cave[i][j] == -1) return;
		if(cave[i][j] > 0) val += cave[i][j];
		cave[i][j] = 0;
		
		if(i-1 > -1) toTop(cave, i-1, j, val);
		if(j-1 > -1) toTop(cave, i, j-1, val);
	}
	
	public int[][] copy(int[][] c)
	{
		int[][] copy = new int[c.length][c.length];
		
		for(int m = 0 ; m < c.length ; m++)
			for(int n = 0 ; n < c.length ; n++)
				copy[m][n] = c[m][n];
		
		return copy;
	}
}