import java.util.*;

class temp 
{	
	public static void main(String args[])
	{
		Set<Integer> hs = new HashSet<>();
		hs.add(9);		
		hs.add(9);		
		hs.add(8);		
		hs.add(19);
		hs.add(7);
		System.out.println("From Hash Set \t\t" + hs);
		
		Set<Integer> lhs = new LinkedHashSet<>();
		lhs.add(9);
		lhs.add(8);	
		lhs.add(9);			
		lhs.add(19);
		lhs.add(7);
		System.out.println("From Linked Hash Set \t" + lhs);
		
		Set<Integer> ts = new TreeSet<>();
		ts.add(9);		
		ts.add(9);		
		ts.add(8);		
		ts.add(19);
		ts.add(7);
		System.out.println("From Tree Set \t\t" + ts);
	}
}



/* 
From Hash Set           [19, 7, 8, 9]
From Linked Hash Set    [9, 8, 19, 7]
From Tree Set           [7, 8, 9, 19]
 
*/