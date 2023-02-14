import java.util.Scanner;

public class OddOccurence {
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
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j] && arr[i] != Integer.MIN_VALUE) {
                    arr[i] = Integer.MIN_VALUE;
                    arr[j] = Integer.MIN_VALUE;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != Integer.MIN_VALUE)
                System.out.print(arr[i] + " ");
        }
    }
}
