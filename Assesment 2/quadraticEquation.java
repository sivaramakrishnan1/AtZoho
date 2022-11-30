import java.util.Scanner;

public class quadraticEquation {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter coefficient of x^2: ");
		double powerX = s.nextDouble();
		System.out.println("Enter coefficient of x: ");
		double x = s.nextDouble();
		System.out.println("Enter constant: ");
		double constant = s.nextDouble();
		
		double val = (x*x) - (4 * powerX * x);
		if(val < 0)
		{
			double imag = val * -1;
			imag = squarRoot(imag);
			val = -x / (2 * powerX);
			System.out.println("" + val + " \u00B1 " + (float)imag + "i");
			s.close();
			return;
		}
		val = squarRoot(val);
		System.out.println(val);
		val = (-x + val)/(2*powerX);
		System.out.println(val);
		
		s.close();
	}
	
	public static double squarRoot(double val) {
		double root = 0.0;
		for( root = 0; root*root == val ; root += 0.01);
		return root;
	}
}