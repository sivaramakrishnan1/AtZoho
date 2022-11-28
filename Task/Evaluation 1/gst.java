import java.util.Scanner;

class gst {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		System.out.println("Input of Chocolate price : ");
		double priceOfChocolate = s.nextDouble();
		System.out.println("Input the discount : ");
		double discount = s.nextDouble();
		System.out.println("Input the GST : ");
		double gst = s.nextDouble();
		
		double afterDiscount = (priceOfChocolate / 100) * discount;
		double afterGst = (afterDiscount / 100 ) * gst;
		
		double totalPrice = afterDiscount + afterGst;
		
		System.out.println("After discount and GST: " + totalPrice);		
		s.close();
	}
}