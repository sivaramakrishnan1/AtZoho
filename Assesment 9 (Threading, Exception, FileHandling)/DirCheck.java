import java.util.Scanner;
import java.io.File;

class DirCheck
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		File f1 = new File("E:\\Illa");
		File f2 = new File("E:\\Irukku");
		
		System.out.println(f1.exists() + " " + f2.exists());
	}
}