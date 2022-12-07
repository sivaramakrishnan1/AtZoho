import java.util.Scanner;

public class Main {
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter the 3 numbers : ");
		Average avg = new Average(s.nextInt(), s.nextInt(), s.nextInt());
		
		avg.printAverage();
		
		s.close();
	} 
}