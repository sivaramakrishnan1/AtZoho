import java.util.Scanner;

class Parking
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int row = s.nextInt(), col = s.nextInt();
		
		int[][] lot = new int[row][col];
		int max = 0, addr = -1;
		
		for(int i = 0 ; i < row ; i++)
		{
			for(int j = 0 ; j < col ; j++)
			{
				lot[i][j] = s.nextInt();
				if(lot[i][j] == 1) max++;
			}
			lot[i][0] = max;
			max = 0;
		}
		max = 0;
		
		for(int i = 0 ; i < row ; i++)
		{
			if(max < lot[i][0]) {
				max = lot[i][0];
				addr = i;
			}
		}
		
		System.out.println(addr + " have " + max + " vehicles");
	}
}