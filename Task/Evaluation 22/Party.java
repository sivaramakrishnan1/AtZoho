import java.util.Scanner;

class Party
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int[][] arr = new int[N][N];
		
		for(int i = 0 ; i < N ; i++)
			for(int j = 0 ; j < N ; j++)
				arr[i][j] = s.nextInt();
		
		System.out.println("Celeb at index : " + getId(arr));
	}
	
	public static int getId(int[][] arr)
	{
		int N = arr.length;
		out : for(int i = 0 ; i < N ; i++) 
		{
			if(isEmpty(arr, i))
			{
				for(int j = 0 ; j < N ; j++)
				{
					if(j == i) continue;
					else if(arr[j][i] != 1) break;
				}
				return i;
			}
		}	
		return -1;
	}
	
	public static boolean isEmpty(int[][] arr, int row)
	{
		for(int i = 0 ; i < arr.length ; i++)
			if(arr[row][i] != 0) return false;
		
		return true;
	}
}