import java.util.Scanner;

class Trap
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int n1 = s.nextInt(), n2 = s.nextInt(), y = s.nextInt();
		String output = "";
		s.close();
		
		for(int i = n1 ; i <= n2 ; i++)
		{
			boolean res = isTrap(i, y);
			System.out.print("(" + i + "," + y + ") -> ");
			if(res) {
				y += 2;
				output += i + " ";
			}
			else 
				if(y > 3) y--;
				else y = 3;
			
			System.out.println("y = " + y);
			
		}
		System.out.println(output);
	}
	
	public static boolean isTrap(int x, int y)
	{
		// System.out.println("Checking => " + x + " " + y);
		
		if(x == y) return true;
		if(x % y == 0 || y % x == 0) return true;
		if(x < 10) return false;
		
		int z = 0;
		while(x > 0)
		{
			z += x % 10;
			x /= 10;
		}
		
		return isTrap(z, y);
	}
}