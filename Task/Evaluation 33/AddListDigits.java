import java.util.Scanner;

class LinkedList {
    int val;
    LinkedList next;

    LinkedList(int val)
    {
        this.val = val;
        next = null;
    }
}

class AddListDigits {
    static LinkedList num1, num2;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String num = s.nextInt() + "";

        for(int i = 0 ; i < num.length() ; i++)
        {
            if(num1 == null) num1 = new LinkedList(num.charAt(i) - '0');
            else
            {
                LinkedList temp = new LinkedList(num.charAt(i) - '0');
                temp.next = num1;
                num1 = temp; 
            }
        }

        num = s.nextInt() + "";
        for(int i = 0 ; i < num.length() ; i++)
        {
            if(num2 == null) num2 = new LinkedList(num.charAt(i) - '0');
            else
            {
                LinkedList temp = new LinkedList(num.charAt(i) - '0');
                temp.next = num2;
                num2 = temp; 
            }
        }
        int carry = 0, sum = 0, power = 1;

        while(num1 != null || num2 != null || carry != 0)
        {
            int val = carry;
            if(num1 != null) {
                val += num1.val;
                num1 = num1.next;
            }
            if(num2 != null) {
                val += num2.val;
                num2 = num2.next;
            }

            carry = val / 10;
            val %= 10;
            sum += (val * power);
            power *= 10;
        }
        System.out.println(sum);
    }    
}
