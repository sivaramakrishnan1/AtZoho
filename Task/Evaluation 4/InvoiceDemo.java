import java.util.Scanner;


class InvoiceDemo
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter part number : " );
		String num = s.next();
		
		System.out.println("Enter part description : " );
		String des = s.next();
		
		System.out.println("Enter part quantity : " );
		int qua = s.nextInt();
		
		System.out.println("Enter part price : " );
		double pri = s.nextDouble();
		
		Invoice item1 = new Invoice(num, des, qua, pri);
		
		System.out.println("\n\n\n---Invoice---");
		System.out.println("Number: " + item1.getNumber() + "\nDescription: " + item1.getDescription() + "\nQuantity: " + item1.getQuantity() + "\nPrice per item : " + item1.getPrice());
		
		System.out.println("\n\nTotal Price: " + item1.getInvoiceAmount());
	}
}