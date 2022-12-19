/* 4. Write a Java program
a. to iterate through all elements in a hash list.
b. to empty an hash set.
c. to convert a hash set to an array.
d. to compare two sets and retain elements which are same on both
sets.
 */
 
import java.util.HashSet;
import java.util.Iterator;

class HashSetProblem
{
	public static void main(String args[])
	{
		HashSet<Integer> hs = new HashSet<>();
		hs.add(9);		
		hs.add(9);		
		hs.add(8);		
		hs.add(19);
		hs.add(7);
		System.out.println(hs);
		
		Iterator<Integer> i = hs.iterator();
		
		while(i.hasNext())
			System.out.print(i.next() + " ");
		
		System.out.println();
		
		Object[] arr = hs.toArray();
		
		for(int k=0 ; k < arr.length ; k++)
		{
			System.out.print(arr[k] + " ");
		}
		System.out.println();
		
		HashSet<Integer> cloneHs = new HashSet<>(hs);
		System.out.println("Comparing two collections : " + hs.containsAll(cloneHs));
	}
}