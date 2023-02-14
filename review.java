import java.util.*;

public class review {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		// for inputs like 100, 1000, and more .. there is a trailing "Zero" as output, which is wrong. 
		// if(n == 0) System.out.println("Zero"); add this to avoid that
		System.out.print(s(n));
	}

	public static String s(int num) {
		String result = "";
		String[] ones = new String[] { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine" };
		String[] tens = new String[] { "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen",
				"Seventeen", "Eighteen", "Nineteen" };
		String[] hundred = new String[] { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty",
				"Ninety" };
		
		// removed 
		/*
		if(num == 0)
		result = "Zero";
		else */ if (num < 10)
			result = ones[num];
		else if (num < 20)
			result = tens[num - 10];
		else if (num < 100)
			result = hundred[num / 10] + " " + s(num % 10);
		else if (num < 1000)
			result = s(num / 100) + " Hundred " + s(num % 100);
		else if (num < 1000000)
			result = s(num / 1000) + " Thousand " + s(num % 1000);
		else if (num < 1000000000)
			result = s(num / 1000000) + " Million " + s(num % 1000000);
		else
			result = s(num / 1000000000) + " Billion " + s(num % 1000000000);
		return result;
	}
}