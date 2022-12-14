import java.util.Scanner;

class Jump
{
	static int min = Integer.MAX_VALUE;
	static String[] all = {"-1", ""};
	
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int[] arr = new int[]{2, 3, 4, 1, 1, 1, 1};
		jump(arr, 0,0, " ");
		System.out.println("For " + all[0] + " steps in the path of " + all[1]);
		s.close();
	}
	
	public static void jump(int[] arr, int pos, int steps, String path) 
	{		
		if(pos >= arr.length) return;
		// System.out.println(pos + " " + arr[pos] + " " + steps + " " + path);
		
		if(pos == arr.length - 1)
		{
			if(steps < min) {
				min = steps;
				all[0] = "" + min;
				all[1] = path;
			}
			return;
		}
		
		if(pos < arr.length - 1)
		{			
			for(int i = 1 ; i <= arr[pos] ; i++)
			{
				jump(arr, pos+i, steps+1, path + "(" + i + " in " + arr[pos] + ") ");
				
			}			
		}
	}
}