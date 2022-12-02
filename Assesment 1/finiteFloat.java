import java.util.Scanner;
import java.lang.String;

class finiteFloat {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		double d = s.nextDouble();		
		float f = (float)d;		
		System.out.println((String.valueOf(f)).equals(String.valueOf(d)));	
		s.close();	
	}
}