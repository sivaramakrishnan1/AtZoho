import java.util.Scanner;

public class Prblm4 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String str = s.next();
        System.out.println(str.matches("^p[a-zA-z0-9]*q$"));
        s.close();
    }
}
