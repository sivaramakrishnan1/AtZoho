import java.util.Scanner;

class WeightNumber
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		int[][] arr = new int[size][2];
		
		for(int i = 0 ; i < size ; i++)
		{
			arr[i][0] = s.nextInt();
			if(isSquare(arr[i][0])) arr[i][1] += 5;
			if(arr[i][0] % 4 == 0 && arr[i][0] % 6 == 0) arr[i][1] += 4;
			if(arr[i][0] % 2 == 0) arr[i][1] += 3;
		}
		
		if(arr.length > 1)
			sortArray(arr);
		
		for(int i = 0 ; i < arr.length; i++)
		{
			System.out.println("<" + arr[i][0] + "," + arr[i][1] + ">");
		}
		
		s.close();
		
	}
	
	public static boolean isSquare(int num)
	{
		for(int i = 0 ; i < num ; i++)
		{
			if(i*i == num) return true;
		}
		
		return false;
	}
	
	public static void sortArray(int[][] arr)
	{
		for(int i = 0 ; i < arr.length - 1 ; i++)
		{
			for(int j = i+1 ; j < arr.length ; j++)
			{
				if(arr[i][1] > arr[j][1])
				{
					int[] temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
}