import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class FileDetails {
  public static void main(String[] args) {
	
	Scanner s = new Scanner(System.in);
	String filename = s.next();
	File f;
	try{
		f = new File(filename);
	}
	catch(Exception e)
	{
		System.out.println("Type panna therinja type pannu");
		e.printStackTrace();
		return;
	}
	
    System.out.println();
    System.out.println("Does that file exist : " + f.exists());
    System.out.println("Does that file readable : " + f.canRead());
    System.out.println("Does that file writeable : " + f.canWrite());
    System.out.println("Size of the file : " + f.length()+ " Bytes");
	String format = f.toString(), ext = "";
	
	for(int i = format.length()-1 ; i > 0 ; i--)
	{
		if(format.charAt(i) != '.')
			ext = format.charAt(i) + ext;
		else 
			break;
	}
	
	switch(ext)
	{
		case "java" : System.out.println("It is a java file"); break;
		case "word" : System.out.println("It is a word file"); break;
		case "txt" : System.out.println("It is a text file"); break;
		case "class" : System.out.println("It is a java compiled byte code (class) file"); break;
		case "pdf" : System.out.println("It is a pdf file"); break;
		default : System.out.println(ext); break;
	}
  }
}

// Output: Language: Java