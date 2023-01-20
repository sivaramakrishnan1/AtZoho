import java.util.Scanner;

class Island
{
	static char[][] map;
	public static void main(String ar[])
	{
		Scanner s = new Scanner(System.in);
		Island obj = new Island();
		
		map = new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
		System.out.println(obj.numIslands(map));
	}
	
	public int numIslands(char[][] grid) {
		int count=0;
		for(int i=0;i<grid.length;i++)
			for(int j=0;j<grid[0].length;j++){
				if(grid[i][j]=='1'){
					occupy(grid,i,j);
					count++;
					
				}
			}
		return count;
	}
	
	private void occupy(char[][] grid, int i, int j)
	{
		if(i > -1 && j > -1 && i < grid.length && j < grid[0].length && grid[i][j] == '1')
		{
			grid[i][j] = '0';
			occupy(grid, i+1, j);
			occupy(grid, i-1, j);
			occupy(grid, i, j+1);
			occupy(grid, i, j-1);			
		}			
	}
	/* 
	private void dfsFill(char[][] grid,int i, int j){
		if(i>=0 && j>=0 && i<grid.length && j<grid[0].length&&grid[i][j]=='1'){
			grid[i][j]='0';
			dfsFill(grid, i + 1, j);
			dfsFill(grid, i - 1, j);
			dfsFill(grid, i, j + 1);
			dfsFill(grid, i, j - 1);
		}
	} */

	
	/* public int numIslands(char[][] grid) {
        char max = '2';
		
		for(int i = 0 ; i < map.length ; i++)
		{
			for(int j = 0 ; j < map[i].length ; j++)
			{
				if(map[i][j] == '1') {
					occupy(i, j, max);
					// System.out.print(map[i][j] + ' ');
					max = (char)(max + 1);
				}
			}
			// System.out.println();
		}		
		
		return max - '2';
    }
	
	public void occupy(int x, int y, char max) {
		int j;
		for(int i = 0 ; i < map.length ; i++)
		{
			for(j = 0 ; j < map[i].length ; j++)
			{
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
		for(int i = x ; i > -1 ; i--) {
			
			j = y;	
			while(j > -1 && map[i][j] != '0') {
				map[i][j] = max;
				j--;
			}
			
			j = y;	
			while(j < map[i].length && map[i][j] != '0') {
				map[i][j] = max;
				j++;
			}
		}
		
		for(int i = x ; i < map.length ; i++) {
			j = y;			
			while(j > -1 && map[i][j] != '0') {
				map[i][j] = max;
				j--;
			}
			
			j = y;
			while(j < map[i].length && map[i][j] != '0') {
				map[i][j] = max;
				j++;
			}
		}
		
		for(int i = 0 ; i < map.length ; i++)
		{
			for(j = 0 ; j < map[i].length ; j++)
			{
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
		map[x][y] = max;
	} */
	
	/* public void occupy(int x, int y, int max)
	{
		int i, j;
		
		i = x;
		j = y;		
		while(i > -1 && map[i][j] != 0)
		{
			map[i][j] = max;
			i--;
		}
		
		i = x;
		j = y;		
		while(i < map.length && map[i][j] != 0)
		{
			map[i][j] = max;
			i++;
		}
		
		i = x;
		j = y;		
		while(j > -1 && map[i][j] != 0)
		{
			map[i][j] = max;
			j--;
		}
		
		i = x;
		j = y;		
		while(j < map.length && map[i][j] != 0)
		{
			map[i][j] = max;
			j++;
		}		
	} */
}