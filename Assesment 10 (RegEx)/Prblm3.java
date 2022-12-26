import java.util.Scanner;

public class Prblm3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.next();
        System.out.println(str.matches("[a-z]*_[a-z]*"));
        s.close();
    }
}
