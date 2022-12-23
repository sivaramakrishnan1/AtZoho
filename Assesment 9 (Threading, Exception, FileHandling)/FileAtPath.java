import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;

class FileAtPath
{
	public static void main(String args[]) throws Exception
	{
		String path = "E:\\java";
		File f = new File(path);
		f.mkdir();
		f = new File(path + "\\abc.txt");
		f.createNewFile();
	}
}