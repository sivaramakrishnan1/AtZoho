import java.util.Scanner;

class Date
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int[] date1 = new int[3];
		int[] date2 = new int[3];
		
		for(int i=0 ; i < 3 ; i++)
			date1[i] = s.nextInt();
		
		for(int i=0 ; i < 3 ; i++)
			date2[i] = s.nextInt();
		
		int num1 = counter(date1), num2 = counter(date2);
		
		System.out.println(num2 - num1);
		s.close();
		
	}
	
	public static int counter(int[] date)
	{
		int[] months = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int count = (date[2] * 365)  + ( date[2] / 4);
		
		for(int i = date[1] ; i > 0 ; i--)
		{
			count += months[i-1];
		}
		
		for(int i = date[0] ; i > 0 ; i--)
		{
			count++;
		}
		
		return count;
	}
}