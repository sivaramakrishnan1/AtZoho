import java.util.Scanner;
import java.io.File;
import java.io.FileOutputStream;

class UppercaseFile
{
	public static void main(String args[]) throws Exception
	{
		Scanner reader = new Scanner(new File("test.txt"));
		String result = "";

		while(reader.hasNextLine())
		{
			result += reader.nextLine() + "\n";
		}
		reader.close();
		
		result = result.toUpperCase();
		
		FileOutputStream out = new FileOutputStream(new File("test.txt"));
		out.write(result.getBytes());
		out.close();
		
	}
}