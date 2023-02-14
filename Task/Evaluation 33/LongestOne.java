import java.util.Scanner;

class LongestOne
{
	int longest = 0;
	
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int val = s.nextInt();
		s.close();
		
		String bit = "";
		
		
		while(val > 0)
		{
			bit = (val % 2) + bit;
			val /= 2;
		}
		
		LongestOne obj = new LongestOne();
		obj.bitManipulate(bit.toCharArray());
		
		System.out.println(obj.longest);
	}
	
	public void bitManipulate(char[] bits)
	{		
		for(int i = 0 ; i < bits.length ; i++)
		{
			if(bits[i] == '0')
			{
				bits[i] = '1';
				int count = countOnes(bits);
				if(longest < count) longest = count;
				bits[i] = '0';
			}
		}
	}
	
	public int countOnes(char[] bits)
	{
		int count = 0, max = 0;
		
		for(int i = 0 ; i < bits.length ; i++) {
			while(i < bits.length && bits[i] == '1')
			{
				count++;
				i++;
			}
			if(max < count) max = count;
			count = 0;
		}
		
		return max;
	}
}