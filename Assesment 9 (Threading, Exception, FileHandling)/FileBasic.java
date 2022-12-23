/* 1. Java program to create a new file
2. Java program to write content into file using FileOutputStream
3. Java program to read content from file using FileInputStream
 */
 
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;

class FileBasic
{
	public static void main(String a[]) throws FileNotFoundException, IOException
	{
		File file;
		FileInputStream reader;
		FileOutputStream writer;
		Scanner fileReader;		
		BufferedReader buffRead;
		try {
			file = new File("Basic.txt");
			file.createNewFile();
			reader = new FileInputStream(file);
			writer = new FileOutputStream(file);
			FileReader in = new FileReader(file);
			fileReader = new Scanner(file);		
			buffRead = new BufferedReader(in);
		} catch(FileNotFoundException e) {
			System.out.println("Engada pochu ??? " + e);
			return;
		} catch(IOException e) {
			System.out.println("Engada pochu ??? " + e);
			return;
		}
		
		// getting the string value to write in the file
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		
		// getting the byte[] value which will be used to write in the file
		byte[] val = str.getBytes();
		
		// file wirtten using FileOutputStream
		writer.write(val);
		
		// reading using FileInputStream 
		int fileAsInt;
		while((fileAsInt = reader.read()) != -1){    
            System.out.print((char)(fileAsInt));    
        } 
		
		// file reading using Scanner
		System.out.println("\n" + fileReader.nextLine());
		
		// file reading using BufferedReader
		System.out.println(buffRead.readLine());
		
		try {
			reader.close();
			writer.close();
			s.close();
			buffRead.close();
		} catch(FileNotFoundException e) {
			System.out.println("Mudinchu");
		}
		
	}
}