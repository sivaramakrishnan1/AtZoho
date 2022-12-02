import java.util.Scanner;

class column {
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int num = s.nextInt();
		String col = "";
		
		if(num > 16384)
		{
			System.out.println("Invalid");
			return;
		}
		System.out.println((26*26));
		if(num > (26*26))
		{
			col += (char)((num / (26*26)) + 64);
			num = num / (26*26);

		}
		else if(num > 26)
		{
			col += (char)((num / 26) + 64);
			num = num / 26;
		}
		else 
		{
			col += (char)((num) + 64);
		}
		
		System.out.println(col);
	}
}
