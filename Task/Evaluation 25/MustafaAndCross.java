import java.util.Scanner;

class MustafaAndCross
{
	public static void main(String args[])
	{
		MustafaAndCross mac = new MustafaAndCross();
		
		Scanner s = new Scanner(System.in);
        int x = s.nextInt(), y = s.nextInt();
        int[][] arr = new int[x][y];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = s.nextInt();
            }
        }
		
		int[][] life = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                life[i][j] = s.nextInt();
            }
        }
        s.close();
        // int[][] arr = {{3,2,5},{8,9,1},{4,7,6}};
		// int[][] life = {{1,1,1}, {1,1,1}, {1,1,1}};

        System.out.println(mac.calculateMinimumHP(arr, life));
	}
	
	public int calculateMinimumHP(int[][] monster, int[][] life)
	{
		for(int i = 0 ; i < monster.length ; i++)
			for(int j = 0 ; j < monster.length ; j++)
				monster[i][j] -= life[i][j];
		
		int hp = 0, pos=0;
		for(int i = 0 ; i < monster.length ; i++)
		{
			int min = Integer.MAX_VALUE;
			pos = -1;
			
			for(int j = 0 ; j < monster.length ; j++) 
				if(min > monster[i][j]) {
					min = monster[i][j];
					pos = j;
				}

			hp += min;
			if(i == monster.length - 1) break;
		}
		
		// hp -= life[life.length-1][pos];
		// int val = 0;
		// for(int i = 0 ; i < dp.length ; i++)
		// {
			// System.out.println(dp[i] + " " + val);
			// val += dp[i];
		// }
		return hp+1;
	}
}