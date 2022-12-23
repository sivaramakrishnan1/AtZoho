import java.util.*;
import java.io.*;

class qn34
{
	public static void main(String a[]) throws Exception
	{
		Scanner s = new Scanner(System.in);
		FileReader reader = new FileReader("Basic.txt");
		FileWriter writer = new FileWriter("Basic.txt", true);
		int i=0;
		while((i = reader.read()) != -1)
		{
			System.out.print((char)i);
		}
		System.out.println();
		
		String str = s.nextLine();
		writer.write(str + "\n");
		reader.close();
		writer.close();
	}
}