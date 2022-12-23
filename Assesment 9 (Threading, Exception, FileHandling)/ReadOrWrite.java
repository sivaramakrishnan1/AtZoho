import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;

class ReadOrWrite
{
	public static void main(String args[]) throws Exception
	{	
		File file = new File("Basic.txt");
		Scanner s = new Scanner(System.in);		
		
		boolean loop = true;
		
		while(loop)
		{
			System.out.println("1. Read\n2. Write");
			switch(s.nextInt())
			{
				case 1 : readTheFile(file); break;
				case 2 : writeTheFile(file); break;
				default : return;
			}
		}
		s.close();
	}
	
	public static void readTheFile(File file) throws Exception
	{	
		Scanner reader = new Scanner(file);
		System.out.print("\n---------file starts---------\n");
		while(reader.hasNext())
		{
			System.out.print("\n" + reader.nextLine());
		}
		reader.close();
		System.out.print("\n---------file ends---------\n");

	}
	
	public static void writeTheFile(File file) throws Exception
	{	
		FileWriter writer = new FileWriter(file, true);
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		writer.write(str + "\n");
		writer.close();
	}
}