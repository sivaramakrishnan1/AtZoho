import java.util.*;
import java.io.*;

class FOS
{
	public static void main(String args[]) throws Exception
	{
		File f = new File("Basic.txt");
		FileOutputStream fout = new FileOutputStream(f);
		String str = "Ithu aabathana puli, ithu asambavitha puli";
		fout.write(str.getBytes());
		fout.close();
	}
}