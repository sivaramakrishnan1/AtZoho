/* 
5. Write a Java program to create a new tree set, add some colors (string)
and print out the tree set

6. Write a Java program
a. to get the element in a tree set which is greater than or equal to the
given element.
b. to get the element in a tree set which is less than or equal to the
given element.
c. to retrieve and remove the first element of a tree set.

*/

import java.util.TreeSet;

class TreeSetProblem
{
	public static void main(String args[])
	{
		TreeSet<String> improper = new TreeSet<>();
		
		improper.add("Violet");
		improper.add("violet");
		improper.add("vIoLeT");
		
		System.out.println(improper);
		// output: [Violet, vIoLeT, violet]
		
		TreeSet<String> proper = new TreeSet<>((String a, String b) -> a.compareToIgnoreCase(b));
		
		proper.add("Violet");
		proper.add("violet");
		proper.add("vIoLeT");
		
		System.out.println("Properly sorted : " + proper);
		// output: Properly sorted : [Violet] (Duplicates are not added to the tree)
		
		TreeSet<Integer> ts = new TreeSet<>();
		ts.add(5);
		ts.add(7);
		ts.add(3);
		ts.add(1);
		ts.add(2);
		
		System.out.println("Element higher than 5: " + ts.higher(5));
		System.out.println("Element lower than 5: " + ts.lower(5));
		System.out.println("Removing first element: " + ts.pollFirst());		
		
		/* 
		Output:
		[Violet, vIoLeT, violet]
		Properly sorted : [Violet]
		Element higher than 5: 7
		Element lower than 5: 3
		Removing first element: 1
		*/
	}
}