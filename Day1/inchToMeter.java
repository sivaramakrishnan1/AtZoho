import java.util.Scanner;

class inchToMeter {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		
		System.out.print("Enter the inch value : ");
		double inch = s.nextDouble();
		
		System.out.println("For the inch " + inch + ", equivalent meter is " + (inch *0.0254));
	}
}	
		