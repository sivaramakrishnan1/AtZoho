import java.util.LinkedList;

/* 
3. Write a Java program
a. to insert elements into the linked list at the first and last position.
b. to get the first and last occurrence of the specified elements in a linked list.
c. to clone an linked list to another linked list.
d. to retrieve but does not remove, the first element of a linked list.
*/
 
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

		LinkedList cloneList = (LinkedList)ll.clone();
		System.out.println("Original list: " + ll + "\nCloned list: " + cloneList);
		
		System.out.println("The first element is: " + ll.getFirst());
		System.out.println("The list after retireving the first element: " + ll);
		

    }
    
}
