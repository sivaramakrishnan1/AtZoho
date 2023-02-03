import java.util.*;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;

class temp {
	public static void main(String args[]) throws Exception
	{
		URL url = new URL("https://stackoverflow.com/questions/6159118/using-java-to-pull-data-from-a-webpage");
		URLConnection con = url.openConnection();
		InputStream is = con.getInputStream();
		
		try(BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
                String line = null;
            
                // read each line and write to System.out
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            }
	}	
}