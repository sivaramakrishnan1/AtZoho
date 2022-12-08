import java.util.Scanner;

public abstract class temp
{    
	static Scanner s = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Helloooo");	
		s.close();
	}
	
	public static void getValue() {
		System.out.println("parent");
	}
}

class copy extends temp{	

	public static void main(String[] args) {
		getValue();	
		s.close();
	}
		
	public static void getValue() {
		System.out.println("child");
	}
}
