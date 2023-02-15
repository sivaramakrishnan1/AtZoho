import java.util.Scanner;

class Climb
{
	static int count = 0;
	
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int steps = s.nextInt();
		s.close();
		
		countWays(steps, 0, " ");
		System.out.println(count);
	}
	
	public static void countWays(int steps, int climbed, String path)
	{
		if(steps <= climbed) 
		{
			System.out.println(path);
			count++;
			return;
		}
		
		countWays(steps, climbed + 1, path + " " + climbed + "-" + 1);
		countWays(steps, climbed + 2, path + " " + climbed + "-" + 2);
		countWays(steps, climbed + 3, path + " " + climbed + "-" + 3);
	}
}