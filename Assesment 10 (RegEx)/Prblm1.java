import java.util.Scanner;

public class Prblm1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String str = s.nextLine();
        System.out.println("Does the string match the pattern : " + str.matches("[a-zA-Z0-9]+"));
        s.close();
    }
}
