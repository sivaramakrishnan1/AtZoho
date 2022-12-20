import java.util.Scanner;

class ChefVote
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
			
		int test = s.nextInt();
		
		for(int i = 0 ; i < test ; i++)
		{
			int chefCount = s.nextInt();
			int mailCount = s.nextInt();
			
			String[][] chef = new String[chefCount][2];
			
			for(int j = 0 ; j < chefCount; j++)
			{
				chef[j][0] = s.next();
				chef[j][1] = s.next();
			}
			String[] mails = new String[mailCount];
			
			for(int j = 0 ; j < mailCount; j++)
			{
				mails[j] = s.next();
			}
			
			System.out.println(whoWins(chef, mails));
		}
		
		s.close();
	}
	
	public static String whoWins(String[][] chefs, String[] mails)
	{
		int[] score = new int[chefs.length];
		
		for(int i = 0 ; i < mails.length ; i++)
		{
			for(int j = 0 ; j < chefs.length ; j++)
			{
				if(mails[i].equals(chefs[j][0]))
				{
					score[j]++;
				}
			}
		}
		
		int max = Integer.MIN_VALUE, count = -1;
		int[] places = new int[score.length];
		
		for(int i = 0 ; i < score.length ; i++) 
		{
			if(max < score[i])
			{
				max = score[i];
				count = 0;
				places[count] = i;
			}
			else if(max == score[i])
			{
				count++;
				places[count] = i;
			}
		}
		String result = "";
		
		for(int i = 0 ; i <= count ; i++)
		{
			result += chefs[places[i]][1] + "\n" + chefs[places[i]][0] + "\n\n";
		}
		return result;		
	}
}