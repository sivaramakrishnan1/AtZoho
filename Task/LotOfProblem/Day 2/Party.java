import java.util.Scanner;

class Party
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		
		int[] entry = new int[T];
		int[] exit = new int[T];
		
		for(int i = 0 ; i < T ; i++)
			entry[i] = s.nextInt();
		
		for(int i = 0 ; i < T ; i++)
			exit[i] = s.nextInt();
		int population = 0, max = -1;
		
		for(int i = 0 ; i < T ; i++)
		{
			population += entry[i] - exit[i];
			if(population > max) max = population;
		}
		
		System.out.println(max);
	}
}