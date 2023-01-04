import java.util.HashMap;
import java.util.Scanner;

public class Task {
	int[][] map = new int[0][2];
	
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int size = s.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = s.nextInt();
        }
        s.close();

        Task t = new Task();
        System.out.println(t.minimumRounds(arr));
    }

    public int minimumRounds(int[] tasks) {
        int total = 0, count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0 ; i < tasks.length ; i++)
            if(map.containsKey(tasks[i])) map.put(tasks[i], map.get(tasks[i]) + 1);
			else map.put(tasks[i], 1);

        for (Integer i : map.values()) {
            if(i < 2) return -1;    
			total += (i / 3);
			total += (i % 3 == 0) ? 0 : 1;
		}

        return total;
    }
	
	/* public int minimumRounds(int[] tasks) {
        int total = 0, count = 0;

        for(int i = 0 ; i < tasks.length ; i++)
            inc(tasks[i]);
		
		for(int i = 0 ; i < map.length ; i++)
		{
			if(map[i][1] < 2) return -1;
			total += (map[i][1] / 3);
			total += (map[i][1] % 3 == 0) ? 0 : 1;
		}

        return total;
    }
	
	public void put(int k, int v)
	{
		int[][] copy = new int[map.length + 1][2];
		
		for(int i = 0 ; i < map.length ; i++)
			copy[i] = map[i];
		
		int[] add = {k, v};
		
		copy[map.length] = add;		
		map = copy;
	}
	
	public void inc(int k)
	{
		for(int i = 0 ; i < map.length ; i++)
			if(map[i][0] == k )
			{
				map[i][1]++;
				return;
			}

		put(k, 1);
	}
	
	public boolean contains(int k)
	{
		for(int i = 0 ; i < map.length ; i++)
			if(map[i][0] == k )
				return true;

		return false;
	}	 */
}
