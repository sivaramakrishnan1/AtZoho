import java.util.ArrayList;
import java.util.Scanner;
public class ArrayList2 {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        // element added at the first postion
        list.add(0, 5);

        System.out.println(list);
        // retrieveing element at some position
        System.out.println("Element at postion : " + list.get(2));

        // finding an element
        Scanner s = new Scanner(System.in);
        System.out.println("Enter a number to search :");
        System.out.println("Index of : " + list.indexOf(s.nextInt()));

        ArrayList<Integer> a = new ArrayList<>();
        a.add(4);
        a.add(1);
        a.add(2);
        a.add(3);

        // comparing elements
        System.out.println("comparing elements: " + a);
        if(a.size() == list.size()) System.out.println("Same size");
        else if(a.size() < list.size()) System.out.println(a + " is Less than the " + list);
        else System.out.println(a + " is greater than the " + list + "\n");

        // printing elements in the list 
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Using get(" + i + "): " + list.get(i));
        }
    }
}