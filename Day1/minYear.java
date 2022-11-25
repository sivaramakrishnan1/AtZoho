// 525600

import java.util.Scanner;

class minYear {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);		
		long minutes = s.nextLong();		
		System.out.println(minutes + " minutes will take " + (minutes/525600) + " year(s) and " + ((minutes%525600)/1440) + " day(s)");
	}
}