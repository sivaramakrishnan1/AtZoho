import java.util.Scanner;

class Distance
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		
		for(int t = 0 ; t < T ; t++)
		{
			int x1 = s.nextInt(), y1 = s.nextInt(), x2 = s.nextInt(), y2 = s.nextInt();
			
			int x = (x1-x2 >= 0) ? x1-x2 : x2-x1;
			int y = (y1-y2 >= 0) ? y1-y2 : y2-y1;
			int val = (int)Math.round(Math.sqrt(((x*x) + (y*y))));
			System.out.println("Answer : " + val);
		}
		
		s.close();
	}
}