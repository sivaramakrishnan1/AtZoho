import java.util.Scanner;

class allSubstring {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        String str = s.next(), pat = s.next();
        int pos = -1;

    outerLoop:
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == pat.charAt(0)) {
                pos = i;
                for (int j = 0; j <= pat.length(); j++) {
                    if (i > str.length())
                        break outerLoop;
                    if (j == pat.length()) {
                        System.out.println(pos+1);
                        break;
                    }
                    if (str.charAt(i) != pat.charAt(j))
                        break;
                    i++;
                }
            }
        }

        s.close();
    }
}