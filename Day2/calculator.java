import java.util.Scanner;

public class calculator {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		
		
		int choice = 0;
		System.out.println("Select an operatioin to perform \n1. Addition \n2. Subtraction \n3. Multiplication \n4. Division ");
		choice = s.nextInt();
		
		System.out.println("Enter two numbers : ");
		double operand1 = s.nextDouble();
		double operand2 = s.nextDouble();
		double result = 0;
		
		switch(choice)
		{
			case 1: {
				result = operand1 + operand2;
				break;
			}
			
			case 2: {
				result = operand1 - operand2;
				break;
			}
			
			case 3: {
				result = operand1 * operand2;
				break;
			}
			
			case 4: {
				if(operand2 == 0) { System.out.println("Infinity"); return;}
				result = operand1 / operand2;
				break;
			}
			
			default : {
				System.out.println("What is wrong with you ? \nWhy can't you select an option from the above list, huh??");
				return;
			}
		}
		
		System.out.println("Result is :" + result);		
		s.close();
	}
}