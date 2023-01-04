import java.util.Scanner;

class TrapWater
{
	public static void main(String args[])
	{
		TrapWater obj = new TrapWater();
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		int[] height = new int[size];
		
		for(int i = 0 ; i < size ; i++)
			height[i] = s.nextInt();
		s.close();
		
		System.out.println(obj.trap(height));
	}
	
	public int trap(int[] height) {
        int val = 0, currval = 0, prev = 0;
		
		for(int i = 1 ; i < height.length ; i++) {
			if(height[prev] <= height[i]) {
				val += currval;
				prev = i;
				currval = 0;
			}
			else
				currval += height[prev] - height[i];
			// System.out.println(val + " " + currval + " " + i + " " + prev);
		}
		// System.out.println("After");
		
        if(prev == height.length - 1) return val;
		
		int limit = prev;
		prev = height.length - 1;
		currval = 0;
		
		for(int i = height.length - 2 ; i >= limit ; i--) {
			// System.out.println(val + " " + currval + " " + i + " " + prev);
			if(height[prev] <= height[i]) {
				val += currval;
				prev = i;
				currval = 0;
			}
			else
				currval += height[prev] - height[i];
		}
		
		return val;
    }
}