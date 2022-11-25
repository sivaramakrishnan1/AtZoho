import java.util.Scanner;

class needForSpeed
{
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		float meter = s.nextInt();
		float hour = s.nextInt() % 24;
		float minutes = s.nextInt() % 60;
		float seconds = s.nextInt() % 60;
		
		float mps = meter / ((hour * 3600) + (minutes * 60) + (seconds));
		float kph = (meter / 1000) / (hour + (minutes / 60) + (seconds / 3600));
		float mph = (meter / (float)1609.344) / (hour + (minutes / 60) + (seconds / 3600));
		System.out.println("Meter per Second: " + mps);
		System.out.println("Kilmeter per hour: " + kph);
		System.out.println("Miles per hour: " + mph);
	}
}