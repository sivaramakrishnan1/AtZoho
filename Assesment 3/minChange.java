import java.util.Scanner;

public class minChange {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str1 = s.next(), str2 = s.next();

        str1 = lowerCase(str1);
        str2 = lowerCase(str2);

        int val = 0;

        for (char c : str1.toCharArray())  val += c;
        for (char c : str2.toCharArray())  val -= c;

        System.out.println((val/'A' < 0) ? (val/'A') * -1 : val/'A');
        s.close();
    }

    public static String lowerCase(String str) {
        String res = "";

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z')
                res += str.charAt(i) - 'A';
            res += str.charAt(i);
        }

        return res;
    }
}
