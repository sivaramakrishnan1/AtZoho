import java.util.Scanner;

public class Prblm {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.next();
        System.out.println(str.matches("^[^g]+$"));
        s.close();
    }    
}
