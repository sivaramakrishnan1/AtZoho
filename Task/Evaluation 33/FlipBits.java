import java.util.Scanner;

class FlipBits {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str1 = s.next(), str2 = s.next();
        s.close();

        if(str1.length() != str2.length())
        {
            while(str1.length() < str2.length()) str1 = "0" + str1;
            while(str2.length() < str1.length()) str2 = "0" + str2;
        }

        int count = 0;
        
        for(int i = 0 ; i < str1.length() ; i++)
        {
            if(str1.charAt(i) != str2.charAt(i)) count++;
        }

        System.out.println(count);
    }    
}
