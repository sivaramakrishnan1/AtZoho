import java.util.Scanner;
import java.util.HashMap;

class Quiz
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
			
		int test = s.nextInt();
		
		for(int i = 0 ; i < test ; i++)
		{
			int n = s.nextInt();
			int m = s.nextInt();
			int size = s.nextInt();
			int[] arr = new int[size];
			
			for(int j = 0 ; j < size ; j++)
				arr[j] = s.nextInt();
			
			System.out.println(count(arr, n, m));
		}
		
		s.close();
	}
	
	public static String count(int[] arr, int n, int m)
	{
		HashMap<Integer, Integer> map = new HashMap<>();
		String str = "";
		
		for(int i = 0 ; i < arr.length ; i++) {
			if(arr[i] <= n) {
				if(map.containsKey(arr[i]) && map.get(arr[i]) < 1) {
					str += arr[i] + " ";
					map.put(arr[i], map.get(arr[i]) + 1);
				}
				else if(map.containsKey(arr[i])) map.put(arr[i], map.get(arr[i]) + 1);
				else map.put(arr[i], 0);
			}
		}
			
		return str;
	}
}