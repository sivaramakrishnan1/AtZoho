import java.util.Scanner;

class Quadruples
{
	static int target, recCount = 0;
	
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		int[] arr = new int[size];
		
		for(int i = 0 ; i < size ; i++)
			arr[i] = s.nextInt();
		
		target = s.nextInt();
		
		s.close();
		quadruples(arr, 0, 0, "", 0);
		System.out.println(recCount);
	}
	
	public static void quadruples(int[] arr, int pos, int value, String path, int count) {
		recCount++;
		if(count > 4) return;
		if(pos == arr.length || count == 4)
		{
			if(value == target && count == 4)
				System.out.println(path);
			return;
		}
			
		for(int i = pos; i < arr.length ; i++) {
			if(count+1 < 5)
				quadruples(arr, i+1, arr[i] + value, path + arr[i] + " " , count+1);
		}
	}
}