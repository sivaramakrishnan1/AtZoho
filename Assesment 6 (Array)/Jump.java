import java.util.Scanner;

class Jump
{
	static int[] arr;
	static int called = 0;
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		arr = new int[]{2, 3, 1, 1, 4};
		
		jump(0, 0);
		System.out.println(called);

		s.close();
	}
	
	public static void jump(int pos, int steps) 
	{
		called++;
		if(pos == arr.length - 1)
		{
			System.out.println("Steps: " + steps);
			return;
		}
		
		if(pos < arr.length - 1)
		{			
			System.out.println(pos + " " + arr[pos] + " " + steps);
			for(int i = pos+1 ; i <= arr[pos] ; i++)
			{
				
				jump(pos+i, ++steps);
			}
		}
	}
}