import java.util.Scanner;

class Chocolate {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int rupees = s.nextInt(), price = s.nextInt(), wrapPrice = s.nextInt(), count = 0, wrapper = 0;

        if (wrapPrice != 1)
            while (rupees > 0 || wrapper > 0) {
                if (rupees < price && wrapper == 0)
                    break;
                if (rupees != 0) {
                    count += rupees / price;
                    wrapper += rupees / price;
                    rupees = rupees % price;
                }

                if (wrapper != 0) {
                    count += wrapper / wrapPrice;
                    wrapper = wrapper / wrapPrice;
                }
            }

        System.out.println(count);
        s.close();
    }

}
