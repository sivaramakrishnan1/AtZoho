import java.util.Scanner;

class Balloon
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		int[] balloons = new int[26];
		
		for(int i = 0 ; i < size ; i++)
		{
			balloons[(s.next().charAt(0) - 'a')]++;
		}
		s.close();
		
		for(int i = 0 ; i < 26 ; i++)
			if(balloons[i] % 2 == 1)
				System.out.print((char)(i + 'a') + " ");
	}
}