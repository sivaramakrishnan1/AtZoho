import java.util.Scanner;

class ProcessKolam
{
	static boolean foundWay = false;
	
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int nodeCount = s.nextInt();
		int[][] arr = new int[nodeCount][nodeCount];
		int edges = s.nextInt();
		
		for(int i = 0 ; i < edges ; i++) {
			int x = s.nextInt() - 1, y = s.nextInt() - 1, val = s.nextInt();			
			arr[x][y] = val;
			arr[y][x] = val;
		}
				
		System.out.println(processKolam(arr, 0, edges-1));
	}
	
	static boolean processKolam(int[][] arr, int x, int edges)
	{
		for(int i = 0 ; i < arr.length ; i++)
		{
			if(arr[x][i] > 0)
			{
				arr[x][i]--;
				arr[i][x]--;
				if(processKolam(arr, i, edges-1)) return true;
				arr[x][i]++;
				arr[i][x]++;
			}
		}
		
		for(int i = 0 ; i < arr.length ; i++)
			for(int j = 0 ; j < arr.length ; j++)
				if(arr[i][j] != 0) return false;
		return true;		
	}
	
	static boolean isEmpty(int[][] arr)
	{
				
	}
}