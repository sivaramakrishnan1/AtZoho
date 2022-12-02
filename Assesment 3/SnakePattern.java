/*
  P   A   H   N
  A P L S I I G
  Y	  I   R
*/

import java.util.Scanner;

// ! Works only for the row input 3 & 4

class SnakePattern 
{
  public static void main(String args[]) 
  {
    Scanner s = new Scanner(System.in);
    String str = s.next();
    int row = s.nextInt();
	boolean flag = false;
	
	int offset = (row - 1) + (row - 2);

    for (int j = 0; j < row; j++) 
	{
		for (int i = 0; i < str.length(); i += offset + 1) 
		{
			if (j == 0) System.out.print(str.charAt(i));
			else if(j < row-1) 
			{
				if (i - j > 0) System.out.print(str.charAt(i - j));
				if (i + j < str.length()) System.out.print(str.charAt(i + j));
			}
			else if(i + j < str.length()) 
			{ 
				flag = true; 	
				System.out.print(str.charAt(i + j));
			}
			
		}
		System.out.println(" " + j + offset);
    }	
	System.out.println(flag);
  }
}