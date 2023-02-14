import java.util.Scanner;

public class wave {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("n=");
        int size = s.nextInt();
        // getting the array
        System.out.print("arr[]=");
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) 
            arr[i] = s.nextInt();

        s.close();


        for (int i = 0; i < size; i+=2) 
        {
            // In case array size is odd,
            // we don't need to swap the last element 
            if(size % 2 != 0 && i == size-1) 
                break;

            // swapping the element positions
            int temp = arr[i];
            arr[i] = arr[i+1];
            arr[i+1] = temp;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        
    }
}
