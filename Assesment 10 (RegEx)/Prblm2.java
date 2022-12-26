import java.util.Scanner;

class Prblm2
{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.next();
        System.out.println(str.matches("[a-zA-z0-9]*pq*"));
        s.close();
    }
}