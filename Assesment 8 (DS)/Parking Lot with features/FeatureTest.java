package Parking;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class FeatureTest
{
	public static void main(String args[])
	{
		try{
			FileWriter writer = new FileWriter("Parking//File.txt", true);
			String s = "Yennomo nadakuthu\n";
			
			writer.write(s);
			writer.close();
			
		} catch(IOException e) {
			System.out.println("Oru file handling panna theriyutha !! Ithayum vechuko ..." + e);
		}
		
		System.out.println("Done");
	}
}