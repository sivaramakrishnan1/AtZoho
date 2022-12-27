import java.util.Scanner;
import java.io.*;

class Rectangle
{
	public static void main(String args[])  
	{
		Scanner s = new Scanner(System.in);
		
		System.out.println("Size row, column: ");
		int[][] arr = new int[s.nextInt()][s.nextInt()];
		
		
		for(int i = 0 ; i < arr.length ; i++)
		{
			for(int j = 0 ; j < arr[i].length ; j++)
			{
				arr[i][j] = s.nextInt();
			}
		}
		
		System.out.println("Enter the row and column of start : ");
		int start1 = s.nextInt(), start2 = s.nextInt();
		
		System.out.println("Enter the row and column of end : ");
		int end1 = s.nextInt(), end2 = s.nextInt(), sum = 0;
		
		try {
			for(int i = start1-1 ; i < end1 ; i++)
			{
				for(int j = start2-1 ; j < end2 ; j++)
				{
					System.out.print(arr[i][j] + " ");
					sum += arr[i][j];
				}
				System.out.println();
			}
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Invalid input " + e);
		}
		
		System.out.println("Sum : " + sum);
		s.close();
	}
}