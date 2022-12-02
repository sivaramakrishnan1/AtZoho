import java.util.Scanner;

class circle {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		System.out.print("Enter the radius : ");
	
		double radius = s.nextDouble();
		double pi = 3.14159265358979323846;
		double perimeter = (pi*2) * radius;
		double area = pi * (radius * radius);
		
		System.out.println("Perimeter of the circle : " + perimeter);
		System.out.println("Area of the circle : " + area);
		s.close();
	}
}