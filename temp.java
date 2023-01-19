import java.util.*;
import java.io.*;

class temp {
	public static void main(String args[])  throws IOException, InterruptedException
	{
		for(int i = 1 ; i <= 50 ; i++)
		{
			
			Thread.sleep(50);
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			/* for(int j = 0 ; j <= i ; j++)
			{
				for(int k = 0 ; k <= j ; k++)
				{
						System.out.print(k + " ");
				}
				System.out.println();
			} */
			
			// / - \ |
			switch(i % 4)
			{
				case 0: System.out.println("\n\n<");break;
				case 1: System.out.println("\n\n^");break;
				case 2: System.out.println("\n\n>");break;
				case 3: System.out.println("\n\nv");break;
			}			
		}
	}
}