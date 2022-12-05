import java.util.Scanner;

class column {
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int num = s.nextInt();
		String col = "";
		
		
		if(num > 16385)
		{
			System.out.println("Invalid");
			return;
		}
		System.out.println(num + " " + col);
		if(num > (26*26))
		{
			col += (char)((num / (26*26)) + 64);
			num = num % (26*26);
			System.out.println(num + " " + col);
		}
		if(num > 26)
		{
			col += (char)((num / 26) + 64);
			num = num % 26;
			System.out.println(num + " " + col);
		}
		if(num > 0) 
		{
			col += (char)(num + 64);
			// System.out.println(num + " " + col + " added");
		}
		
		System.out.println(col);
	}
}
