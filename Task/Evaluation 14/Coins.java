import java.util.Scanner;
import java.util.HashMap;

class Coins
{
    static int[] coins;
	static int count = 0;
	static HashMap<Integer, String> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int size = s.nextInt();

        coins = new int[size];
        int[] counts = new int[0];
		
        for (int i = 0; i < size; i++) {
            coins[i] = s.nextInt();
        }

        int n = s.nextInt();
		
		n *= -1;
		
        findCombination(n, counts);
        
		
		System.out.println("Count : " + count);
		s.close();
    }

    public static void findCombination(int n, int[] counts)
    {
        if(n > 0) return;
		
        if(n == 0) {
			counts = sort(counts);
			String combination = toString(counts);

			if(!map.containsValue(combination))
			{
				map.put(++count, combination);
				System.out.println(combination);
			}		
			return;	
        }

        for(int i = 0 ; i < coins.length ; i++)
        {
			if(n + coins[i] < 1)
				findCombination(n + coins[i], addElement(counts, coins[i]));
        }
    }
	
	public static int[] sort(int[] arr)
	{
		for(int i = 0 ; i < arr.length ; i++)
		{
			for(int j = i+1 ; j < arr.length ; j++)
			{
				if(arr[i] > arr[j])
				{
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}		
		return arr;
	}

	public static int[] addElement(int[] arr, int ele)
	{
		int[] copy = new int[arr.length + 1];
		int i;
		for (i = 0; i < arr.length; i++) {
			copy[i] = arr[i];
		}

		copy[i] = ele;
		return copy;
	}

	public static String toString(int[] arr)
	{
		String val = "";

		for (int i = 0; i < arr.length; i++) {
			val += arr[i] + " ";
		}

		return val;
	}
}