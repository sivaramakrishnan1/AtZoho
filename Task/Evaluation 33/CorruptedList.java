import java.util.HashMap;
import java.util.Scanner;

class LinkedList {
    String val;
    LinkedList next;

    LinkedList(String val)
    {
        this.val = val;
        next = null;
    }
}

class CorruptedList {
    static LinkedList head, node;
    static HashMap<LinkedList, Integer> map = new HashMap<>();
    public static void main(String[] args) throws InterruptedException{
        // Scanner s = new Scanner(System.in);
        // String in;
        // System.out.println("Enter -1 at the end of the input to mark the end of stream");
        // while((in = s.next()).equals("-1"))
        // {
        //     if(head == null) {
        //         head = new LinkedList(in);
        //         node = head;
        //     }
        //     else {
        //         node.next = new LinkedList(in);
        //         node = node.next;
        //     }
        // }

        head = new LinkedList("A");

        node = head;
        node.next = new LinkedList("B");
        node = node.next;
        node.next = new LinkedList("C");
        node = node.next;
        LinkedList corrupt = node;
        node.next = new LinkedList("D");
        node = node.next;
        node.next = corrupt;

        node = head;
        map.put(head, 1);

        while(node != null)
        {
            if(map.containsKey(node.next))
            {
                node.next = null;
                break;
            }
            map.put(node, 1);
            node = node.next;
        }

        node = head;

        while(node != null)
        {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
