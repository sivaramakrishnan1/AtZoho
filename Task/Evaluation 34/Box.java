import java.util.Scanner;

class Box {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        int val = 0, size = s.nextInt();
        

        for(int i = 0 ; i < size ; i++)
        {
            s.nextInt();
            val += s.nextInt();
            s.nextInt();
        }
        s.close();
        System.out.println(val);
    }    
}
