/* 
10. Write a Java program to associate the specified value with the specified
key in a Tree Map.
11. Write a Java program
a. to copy a Tree Map content to another Tree Map.
b. to search a key in a Tree Map.
c. to get a key-value mapping associated with the greatest key and the
least key in a map.
d. to get NavigableSet view of the keys contained in a map.
e. to get a key-value mapping associated with the least key greater
than or equal to the given key. Return null if there is no such key.
*/

import java.util.TreeMap;
import java.util.NavigableSet;

class TreeMapProblem
{
	public static void main(String args[])
	{
		TreeMap<Integer, String> tm = new TreeMap<>();
		
		// 10. Write a Java program to associate the specified value with the specified key in a Tree Map.
		tm.put(3, "Siva");
		tm.put(2, "Rama");
		tm.put(4, "B.E.");
		tm.put(1, "Krishnan");
		
		TreeMap<Integer, String> copy = new TreeMap<>(tm);
		System.out.println("Original: " + tm + "\nCopy: " + copy);	

		// b. to search a key in a Tree Map.
		System.out.println("Searching for key '3': " + tm.containsKey(3));
		
		// c. to get a key-value mapping associated with the greatest key and the least key in a map.
		System.out.println("First entry: " + tm.firstEntry() + "\nLast Entry: " + tm.lastEntry());
		
		// d. to get NavigableSet view of the keys contained in a map.
		NavigableSet<Integer> ns = tm.navigableKeySet();
		System.out.println("Navigable map containing key values of treemap: " + ns);
		
		// e. to get a key-value mapping associated with the least key greater than or equal to the given key. Return null if there is no such key.
		System.out.println("Map greater than or equal to 1: " + tm.ceilingEntry(1));		
	}
}