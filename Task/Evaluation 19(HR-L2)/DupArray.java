import java.util.Scanner;

class DupArray 
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		
		String nums = s.nextLine();
		s.close();
		
		String[] arr = nums.split(",");
		String[] num = new String[arr.length];
		int pos = 0, i, j;
		
		for(i = 0 ; i < arr.length ; i++)
		{
			for(j = i-1 ; j > -1 ; j--)
			{
				if(arr[i].equals(arr[j]))
				{
					break;
				}
			}
			if(j == -1)
			{
				num[pos++] = arr[i];
			}
		}
		
		for(i = 0 ; i < num.length ; i++)
		{
			if(num[i] == null) System.out.print("_ ");
			else System.out.print(num[i] + " ");
		}
	}
}