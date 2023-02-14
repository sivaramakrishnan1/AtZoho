import java.util.Scanner;

class Qn3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int size = s.nextInt();
        int[] arr = new int[size];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = s.nextInt();
        }

        s.close();
        int i;
        for (i = 0; i < arr.length;) {
            int max = 0;
            for (int j = i+1; j < arr.length && j <= arr[i] + i; j++) {
                if(arr[j] + j >= max) {
                    max = arr[j];
                }
            }
            i += max;
            if(max == 0) {
                break;
            }
        }

        if(i >= arr.length - 1) System.out.println(true);
        else System.out.println(false);
    }    
}
