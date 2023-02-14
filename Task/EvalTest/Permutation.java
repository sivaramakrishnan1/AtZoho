import java.util.Scanner;
import java.util.TreeSet;

class Permutation {
    static TreeSet<String> list = new TreeSet<>();

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        System.out.print("str = ");
        String str = s.next();

        permute(str, 0, str.length());
        s.close();

        System.out.println(list);
    }

    public static void permute(String str, int start, int end) {
        if (start == end) {
            list.add(str);
            return;
        }

        for (int i = start; i < end; i++) {
            str = swap(str, start, i);
            permute(str, start + 1, end);
            str = swap(str, start, i);
        }
    }

    public static String swap(String str, int in1, int in2) {
        char[] arr = str.toCharArray();
        char temp = arr[in1];
        arr[in1] = arr[in2];
        arr[in2] = temp;

        return String.valueOf(arr);
    }
}