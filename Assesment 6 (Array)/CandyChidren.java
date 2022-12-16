import java.util.Scanner;

class CandyChidren
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int c = 0, count = 0;
		int[] ratings = {1,2,8,8,8,2,1};
		int[] candy = new int[ratings.length];
		
		for(int i = 0 ; i < ratings.length ; i++)
			candy[i] = 1;
		
		for(int i = 0 ; i < ratings.length - 1 ; i++)
		{
			if(ratings[i] > ratings[i+1] ) c++;
			else c = 0;
            candy[i] += c;
			System.out.print(candy[i] + " ");
		}
		
        c = 0;
		System.out.println();

		for(int i = ratings.length - 1 ; i > 0; i--)
		{
			if(i > 0 && ratings[i] > ratings[i - 1] ) c++;
			else c = 0;
            candy[i] += c;
			System.out.print(candy[i] + " ");
		}
		System.out.println();
		for(int i = ratings.length - 1 ; i > -1; i--)
		{
			System.out.print(candy[i] + " ");
			count += candy[i];
		} 
		
		System.out.println(count);
		s.close();
	}
}

/* class CandyChidren
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		
		int[] kidsRate = new int[size];
		
		for(int i = 0 ; i < size ; i++)
		{
			kidsRate[i] = s.nextInt();
		}
		
		int candies = size;
		
		for(int i = 0 ; i < size ; i++)
		{
			if(i > 0 && kidsRate[i] > kidsRate[i-1])
				candies++;
			else if(i+1 < size && kidsRate[i] > kidsRate[i+1])
				candies++;
		}
		
		System.out.println(candies);
		
		s.close();
	}
} */