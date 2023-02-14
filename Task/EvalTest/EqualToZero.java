import java.util.Scanner;

public class EqualToZero {
    static int count = 0;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("arr size = ");
        int size = s.nextInt();
        System.out.print("arr[] = ");
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = s.nextInt();
        }
        s.close();
        for (int i = 0; i < arr.length; i++) {
            int val = 0;
            for (int j = i; j < arr.length; j++) {
                val += arr[j];
                if (val == 0)
                    count++;
            }
        }
        System.out.println(count);
    }
}