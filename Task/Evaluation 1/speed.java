import java.util.Scanner;

class speed {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int distance = s.nextInt();
		int upSpeed = s.nextInt();
		int downSpeed = s.nextInt();
		
		int upTime = distance / upSpeed;
		int downTime = distance / downSpeed;
		
		System.out.println("Total time : " + (upTime+downTime) + " hours\nAverage time : " + ((upSpeed + downSpeed) / 2) + " kmph");
		
		s.close();
	}
}