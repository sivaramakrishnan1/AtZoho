import java.util.Scanner;

class expression {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		
		double a = s.nextDouble();
		double b = s.nextDouble();
		double c = s.nextDouble();
		
		double val = (1/(a*a)) + (2/(b*b)) + (3/(c*c));
		System.out.println((float)val);
		
		s.close();
	}
}