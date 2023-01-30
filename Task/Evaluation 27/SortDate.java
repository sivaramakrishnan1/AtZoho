import java.util.*;

class SortDate
{
	static String[] months = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};
	static int curryear = 2021;
	
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int sentenceCount = s.nextInt();
		
		s.nextLine();
		
		String[] strs = new String[sentenceCount];
		int[] ans = new int[sentenceCount];
		
		for(int i = 0 ; i < sentenceCount ; i++)
			strs[i] = s.nextLine();
		
		for(int i = 0 ; i < sentenceCount ; i++)
			ans[i] = getValue(strs[i]);
		
		for(int i = 0 ; i < sentenceCount ; i++)
		{
			for(int j = 0 ; j < sentenceCount ; j++)
			{
				if(ans[i] > ans[j]){
					int temp = ans[i];
					ans[i] = ans[j];
					ans[j] = temp;
					
					String temps = strs[i];
					strs[i] = strs[j];
					strs[j] = temps;
				}
			}
		}
		
		System.out.println();
		
		for(int i = 0 ; i < sentenceCount ; i++)
			System.out.println(strs[i]);

	}
	
	
	public static int getValue(String str)
	{
		int month = 0 ,year = 0, date = 0;
		for(int i = 0 ; i < 12 ; i++)
		{
			int pos = str.indexOf(months[i]);
			if(pos != -1)
			{
				month += i;
				try {
				year += Integer.parseInt("" + str.charAt(pos+4)+ str.charAt(pos+5) + str.charAt(pos+6) + str.charAt(pos+7));
				} catch (Exception e) {}
				
				try { 
					date += Integer.parseInt(str.charAt(pos-4) + "");
				} catch (Exception e) {}
				
				try {
				date += 10 * Integer.parseInt(str.charAt(pos-5) + "");
				} catch (Exception e) {}
			}
		}
		
		if(year == 0) return ((12 - month) * 30) + (30 - date);
		return ((2021 - year) * 365) + ((12 - month) * 30) + (30 - date);
	}
}