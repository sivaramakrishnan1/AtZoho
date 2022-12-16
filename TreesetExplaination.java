// import java.util.Scanner;
import java.util.*;

class TreeSetExplaination
{
	public static void main(String args[])
	{
		List<Integer> l = new ArrayList<>();
		l.add(5);
		l.add(7);
		l.add(3);
		l.add(1);
		l.add(2);
		
		System.out.println(l);	
		TreeSet<Integer> t = new TreeSet<>();
		
		System.out.println("Returns first element: " + t.first());
		System.out.println("Returns last element: " + t.last());
		
		System.out.println("Removes first element: " + t.pollFirst());
		System.out.println("Removes last element: " + t.pollLast());
		
		System.out.println("Returns the greatest element which is <= passed element: " + t.floor(5));
		System.out.println(t);
		
	}
}