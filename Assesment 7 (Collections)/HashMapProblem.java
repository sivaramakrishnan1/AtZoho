/* 
8. Write a Java program to associate the specified value with the specified
key in a HashMap.
9. Write a Java program
a. to count the number of key-value (size) mappings in a map
b. to copy all of the mappings from the specified map to another map.
c. to check whether a map contains key-value mappings (empty) or
not.
d. to get a shallow copy of a HashMap instance.
e. to get a collection view of the values contained in this map. 
*/

import java.util.HashMap;

class HashMapProblem
{
	public static void main(String args[])
	{
		HashMap<Integer, String> map = new HashMap<>();
		
		map.put(1, "Siva");
		map.put(2, "Rama");
		map.put(3, "Krishnan");
		
		// 8. Write a Java program to associate the specified value with the specified key in a HashMap.
		System.out.println(map);
		
		// a. to count the number of key-value (size) mappings in a map
		System.out.println("Size: " + map.size());
		
		// b. to copy all of the mappings from the specified map to another map.
		HashMap copyMap = new HashMap<>(map);		
		System.out.println("Original : " + map + "\nDuplicate : " + copyMap);
		System.out.println("Original : " + map + "\nDuplicate : " + copyMap);
		
		// shallow copy
		copyMap = map;
		map.put(4, "B.E.");
		System.out.println("Original : " + map + "\nDuplicate : " + copyMap);
		
		// e. to get a collection view of the values contained in this map. 
		System.out.println("Values only of map: " + map.values());		
	}
}