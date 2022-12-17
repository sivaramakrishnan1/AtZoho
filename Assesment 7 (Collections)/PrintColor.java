import java.util.ArrayList;

public class PrintColor {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Red");
        list.add("Blue");
        list.add("White");

        for(String s: list)
        {
            System.out.println(s);
        }
    }    
}
