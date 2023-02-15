import java.util.Scanner;

class RecursiveAdd
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int num1 = s.nextInt(), num2 = s.nextInt();
		s.close();
		
		System.out.println(addValues(num1, num2));
	}
	
	static int addValues(int num, int count)
	{
		if(count == 1) return num;
		return num + addValues(num, count-1);
	}
}