/*
To input marks of five subjects Physics, Chemistry, Biology, Mathematics and
Computer. Calculate percentage and grade according to following:
Percentage >= 90% : Grade A
Percentage >= 80% : Grade B
Percentage >= 70% : Grade C
Percentage >= 60% : Grade D
Percentage >= 40% : Grade E
Percentage < 40% : Grade F

 */

import java.util.Scanner;

public class report {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		double phy, che, bio, mat, com;
		/* System.out.print("Enter the marks of Physics : ");
		phy = s.nextDouble();
		
		System.out.print("Enter the marks of Chemistry: ");
		che = s.nextDouble();
		
		System.out.print("Enter the marks of Biology: ");
		bio = s.nextDouble();
		
		System.out.print("Enter the marks of Maths: ");
		mat = s.nextDouble();
		
		System.out.print("Enter the marks of Computer: ");
		com = s.nextDouble(); */
		
		System.out.print("\nEnter the marks of Physics, Chemistry, Biology, Maths and Computer Science : ");
		double percent = (s.nextDouble() + s.nextDouble() + s.nextDouble() + s.nextDouble() + s.nextDouble())/5;
		System.out.println("\n\nPercent : " + percent + "%");		

		if(percent > 89) System.out.println("Grade A");
		else if(percent > 79) System.out.println("Grade B");
		else if(percent > 69) System.out.println("Grade C");
		else if(percent > 59) System.out.println("Grade D");
		else if(percent < 39) System.out.println("Grade E");
		else System.out.println("Grade F");	
		
		s.close();
	}
}