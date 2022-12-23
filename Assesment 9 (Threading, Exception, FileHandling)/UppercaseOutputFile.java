import java.util.Scanner;
import java.io.*;

class UppercaseOutputFile
{
	public static void main(String args[]) throws Exception
	{
		Scanner s = new Scanner(System.in);
		FileWriter writer = new FileWriter("Basic.txt", true);
		
		String str = s.nextLine();
		writer.write(str.toUpperCase() + "\n");
		writer.close();
	}
}