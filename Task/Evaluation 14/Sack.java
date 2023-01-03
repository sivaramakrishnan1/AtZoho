import java.util.Scanner;

class Sack
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		String pos = "";
		
		System.out.println("Capacity of the sack : ");
		int capacity = s.nextInt();
		
		System.out.println("Size of the sack : ");
		int size = s.nextInt();
		int[] weight = new int[size];
		int[] value = new int[size];		
		
		System.out.println("Enter the weights : ");
		for(int i = 0 ; i < size ; i++)
			weight[i] = s.nextInt();
		
		System.out.println("Enter the values : ");
		for(int i = 0 ; i < size ; i++)
			value[i] = s.nextInt();
		
		int max = -1;
		
		for(int i = 0 ; i < size ; i++) 
		{
			for(int j = i+1 ; j < size ; j++)
			{
				if(weight[i] + weight[j] <= capacity && value[i] + value[j] > max)
				{
					max = value[i] + value[j];
					pos = i + " " + j;
				}
			}
		}
		
		System.out.println("Values at position " + pos + " gives " + max);
		s.close();
	}	
}