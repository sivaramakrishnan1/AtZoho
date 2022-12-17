import java.util.LinkedList;

public class LinkedListProblem {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(10);
        ll.add(11);
        ll.add(11);
        ll.add(13);
        System.out.println(ll);
        // adding element at the first
        ll.addFirst(9);
        // adding element at the last
        ll.addFirst(14);

        System.out.println(ll);
        // printing first and last element
        System.out.println("First element : " + ll.getFirst() + "\nLast element : " + ll.getLast());

        // first and last index of the duplicate element
        System.out.println("First occurence of element 11 in list is : " + ll.indexOf(11) + "\nWhereas last index is in position: " + ll.lastIndexOf(11));



    }
    
}
