import java.util.HashMap;
import java.util.Scanner;

class EqualElements
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		int[] arr = new int[size];
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0 ; i < size ; i++) {
			arr[i] = s.nextInt();
			
			if(map.containsKey(arr[i])) map.put(arr[i], map.get(arr[i]) + 1);
			else map.put(arr[i], 1);
		}
		s.close();
		
		int max = 0;		
		for(int count : map.values()) if(count > max) max = count;
		
		System.out.println(arr.length - max);
	}
}