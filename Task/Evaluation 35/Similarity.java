import java.util.HashMap;
import java.util.Scanner;

class Similarity
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		int[][] values = new int[size][];
		int[] ids = new int[size];
		
		for(int i = 0 ; i < ids.length ; i++)
		{
			ids[i] = s.nextInt();
			size = s.nextInt();
			
			values[i] = new int[size];
			
			for(int j = 0 ; j < size ; j++)
				values[i][j] = s.nextInt();			
		}
		
		/* for(int i = 0 ; i < values.length ; i++)
		{
			for(int j = 0 ; j < values[i].length ; j++)
				System.out.print(values[i][j] + " " );
			System.out.println();
		} */
		
		for(int i = 0 ; i < values.length-1 ; i++)
		{			
			for(int j = i+1 ; j < values.length ; j++)
			{
				HashMap<Integer, Integer> map = getDataMap(values[i], values[j]);
				int intersection = 0, union = map.size();
				
				for(int repeat : map.values())
				{
					if(repeat > 1) intersection++;
				}
				
				double similiarity = (double)intersection / (double)union;
				
				if(similiarity > 0)
					System.out.println(String.format("%s , %s : %s", ids[i], ids[j], similiarity));
			}
		}
	}
	
	static HashMap<Integer, Integer> getDataMap(int[] arr1, int[] arr2)
	{
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0 ; i < arr1.length ; i++)
		{
			if(map.containsKey(arr1[i])) map.put(arr1[i], map.get(arr1[i]) + 1);
			else map.put(arr1[i], 1);
		}
		
		for(int i = 0 ; i < arr2.length ; i++)
		{
			if(map.containsKey(arr2[i])) map.put(arr2[i], map.get(arr2[i]) + 1);
			else map.put(arr2[i], 1);
		}
		
		return map;
	}
}