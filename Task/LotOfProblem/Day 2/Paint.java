import java.util.Scanner;

class Paint
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		
		int in = s.nextInt(), ex= s.nextInt();
		float inside = 0, outside = 0;
		
		for(int i = 0 ; i < in ; i++)
			inside += s.nextFloat();
		
		for(int i = 0 ; i < ex ; i++)
			outside += s.nextFloat();
		s.close();
		
		System.out.println("Total estimated Cost : " + ((inside * 18) + (outside * 12)) + " INR");
		
	}
}