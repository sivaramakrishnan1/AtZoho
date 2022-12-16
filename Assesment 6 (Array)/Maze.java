class Maze
{
	int[][] grid = {{0,0,0,0} , {0,1,0,1} ,{0,1,0,1} , {0,0,0,0}};
	public static void main(String args[])
	{
		Maze m = new Maze();
		
		m.findPaths(0, 0, "");
	}
	
	public void findPaths(int currX, int currY, String path)
	{
		if(currX == grid.length-1 && currY == grid[0].length-1)
		{
			System.out.println(path);
			return;
		}
		// System.out.println(path);
		if(currY+1 < grid[0].length && grid[currX][currY + 1] != 1)
			findPaths(currX, currY+1, path + "->right ");
		if(currX+1 < grid.length && grid[currX + 1][currY] != 1)
			findPaths(currX+1, currY, path + "->down ");
	}
}