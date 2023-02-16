import java.util.Scanner;

class NQueen {
    boolean[][] arr;
    int count = 0;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        s.close();

        NQueen obj = new NQueen();
        obj.arr = new boolean[n][n];
        obj.countPaths(obj.arr, 0);

        System.out.println(obj.count);
    }

    void countPaths(boolean[][] arr, int pos) {
        if (pos == arr.length) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
            count++;
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            boolean trigger = false;
            for (int j = pos - 1; j >= 0; j--) {
                if (arr[j][i]) {
                    trigger = true;
                    break;
                }
            }
            if (trigger)
                continue;
            trigger = false;

            int temp = i;
            for (int j = pos; j >= 0 && temp >= 0; j--, temp--) {
                if (arr[j][temp]) {
                    trigger = true;
                    break;
                }
            }
            if (trigger)
                continue;
            trigger = false;

            temp = i;
            for (int j = pos; j >= 0 && temp < arr.length; j--, temp++) {
                if (arr[j][temp]) {
                    trigger = true;
                    break;
                }
            }
            if (trigger)
                continue;

            arr[pos][i] = true;
            countPaths(arr, pos + 1);
            arr[pos][i] = false;
        }
    }
}