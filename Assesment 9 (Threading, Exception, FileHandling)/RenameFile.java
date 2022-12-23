import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;


class RenameFile
{
	public static void main(String args[]) throws Exception
	{
		File f = new File("FileRename.txt");
		
		f.createNewFile();
		Scanner s = new Scanner(System.in);
		String name = s.next();
		f.renameTo(new File(name));
		f = new File(name);
		s.next();
		f.delete();
	}
}