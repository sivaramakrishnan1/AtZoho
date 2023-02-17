import java.util.Scanner;
import java.util.*;

class NegativeAgeException extends Exception {
	public NegativeAgeException(String err, int givenAge)
	{
		if(givenAge < -5) System.out.println("ImpossibleAge");
	}
}
class CreateException
{
	public static void main(String args[]) throws NegativeAgeException
	{
		Scanner s = new Scanner(System.in);
		System.out.print("\tEnter your age : ");
		
		try {
			int age = s.nextInt();
			System.out.println();
			
			if(age < 0) throw new NegativeAgeException("NegativeAgeException : Age value is in negative", age);
			
		} catch(InputMismatchException e) {
			System.out.println("\tPlease enter a valid age.");
		} finally {
			System.out.println("\tEnding the process ... ");
		}
	}
}