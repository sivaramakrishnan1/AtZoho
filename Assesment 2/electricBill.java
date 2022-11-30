import java.util.Scanner;

public class electricBill {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the unit of electricity consumed : ");
		int unit = s.nextInt();
		double bill = 0;
		if(unit > 250) bill = unit * 1.5;
		else if(unit > 150) bill = unit * 1.2;
		else if(unit > 50) bill = unit * 0.75;
		else bill = unit * 0.5;
		
		System.out.println("Bill is \u20B9" + bill);
		s.close();
	}
}