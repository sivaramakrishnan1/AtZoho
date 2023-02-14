import java.util.Scanner;

class Querry {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[][] arr = new int[n][];

        for (int i = 0; i < arr.length; i++) {
            System.out.println("Array size : ");
            int size = s.nextInt();
            arr[i] = new int[size];

            System.out.println("Array elements : ");
            for (int j = 0; j < size; j++) 
            arr[i][j] = s.nextInt();
        }

        System.out.println("Querry count : ");
        int querryCount = s.nextInt();

        for (int i = 0; i < querryCount; i++) {
            int x = s.nextInt(), y = s.nextInt();
            if(x-1 < arr.length && y-1 < arr[x-1].length) System.out.println(arr[x-1][y-1]);
            else System.out.println("Error");            
        }
        s.close();
    }
}
