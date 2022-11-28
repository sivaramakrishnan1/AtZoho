import java.util.Scanner;

class timeInSeconds {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int sec = s.nextInt();
		int hour, min;
		
		if(sec >= 3600) { hour = sec / 3600; sec %= 3600; }
		else hour = -1;
		
		if(sec > 60) { min = sec / 60; sec %= 60;}
		else min = -1;
		
		if(hour != -1) System.out.print(hour + " Hour ");
		if(min != -1) System.out.print(min + " Minute ");
		if(sec != -1) System.out.print(sec + " Seconds ");
		
		s.close();
	}
}