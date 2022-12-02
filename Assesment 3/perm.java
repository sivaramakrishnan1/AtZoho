import java.util.Scanner;

public class perm {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.next();
        //int[] nums = new int[str.length()];

        for (int i = 0; i < str.length(); i++) {
            //nums = new int[]{i};
            permute(str, i);
            System.out.println();
        }
        

        s.close();
    }


    public static void permute(String str, int pos) {
        
        for (int i = str.length(); i > 0; i--) {
            int temp = (i +  pos) % str.length();
            if (i == pos){
                System.out.print(str.charAt(pos));
			}
            else {
                System.out.print(str.charAt(temp));
            }
        }
    }

    public static boolean isInArray(int[] arr, int val)
    {
        for (int i = 0; i < arr.length; i++) 
            if(arr[i] == val) return true;
        return false;
    }
}
