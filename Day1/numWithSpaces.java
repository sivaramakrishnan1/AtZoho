import java.util.Scanner;

class numWithSpaces {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int var = s.nextInt();
		int val = 1;
		
		while(val < var)
			val *= 10;
		
		while(var > 0)
		{
			val /= 10;
			System.out.print(var/val + " ");
			var = var % val;
		}
	}
}
