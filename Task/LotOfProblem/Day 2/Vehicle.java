import java.util.Scanner;

class Vehicle
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int v = s.nextInt(), w = s.nextInt();
		if(w / 2 < v || w % 2 == 1) 
		{
			System.err.println("Mudinchu .. ");
			return;
		}
		
		System.out.println("four wheeler: " + (w-2 * v)/2);
		System.out.println("two wheeler: " + (v - ((w-2 * v)/2)));
	}
}