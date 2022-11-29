import java.util.Scanner;

class lcm 
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int first = s.nextInt(), sec = s.nextInt();
		int small = (first < sec) ? first : sec;
		int lcm = 1;
		while(small > 1)
		{
			if(first % small == 0 && sec % small == 0) {
				lcm = small;
				small--;
			}
			else
				small--;
		}

		System.out.println(lcm);
		s.close();
	}
}