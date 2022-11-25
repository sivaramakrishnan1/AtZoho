import java.util.Scanner;

class tempConvert {
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		double fah;
		
		System.out.print("Enter the fahrenheit: ");
		fah = s.nextDouble();
		
		System.out.println("For " + fah + "f , equivalent celcius is " + ((fah - 32)*0.5555555555555556) + "C");
	}
}