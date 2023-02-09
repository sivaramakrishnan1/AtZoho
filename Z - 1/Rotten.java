import java.util.Scanner;

class Rotten
{
	static int max = 1;
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int row = s.nextInt(), col = s.nextInt();
		int[][] grid = new int[row][col];
		
		for(int i = 0 ; i < row ; i++)
			for(int j = 0 ; j < col ; j++)
				grid[i][j] = s.nextInt();
			
		s.close();
		Rotten r = new Rotten();
		for(int i = 0 ; i < row ; i++)
			for(int j = 0 ; j < col ; j++)
				if(grid[i][j] == 2) {
					grid[i][j] = 1;
					r.rot(grid, i, j, 1);
				}
			
		for(int i = 0 ; i < row ; i++) { 
			for(int j = 0 ; j < col ; j++) { 
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
		
		
		
		for(int i = 0 ; i < row ; i++) 
		{ 
			for(int j = 0 ; j < col ; j++)
			{
				if(grid[i][j] == 1) 
				{
					System.out.println("-1");
					return;
				}
			}
		}
		
		System.out.println(max);
	}
	
	public void rot(int[][] grid, int i, int j, int rotval)
	{		
		if(grid[i][j] != 1) return;
		
		grid[i][j] += rotval;
		if(rotval > max) max = rotval;
		
		if(i != 0 && grid[i-1][j] == 1) rot(grid, i-1, j, rotval+1);
		if(j != 0 && grid[i][j-1] == 1) rot(grid, i, j-1, rotval+1);
		if(i != grid.length - 1 && grid[i+1][j] == 1) rot(grid, i+1, j, rotval+1);
		if(j != grid[0].length - 1 && grid[i][j+1] == 1) rot(grid, i, j+1, rotval+1);
		max++;
	}
}