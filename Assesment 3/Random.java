import java.util.Scanner;

class random
{
	public static void main(String ags[])
	{
		Scanner s = new Scanner(System.in);		
		String str = s.next();
		
		System.out.println(recPrint(new String(str)));
		s.close();
	}
	
	public static String recPrint(String str)
	{
		if(str.length() <= 2)
			return str;
		
		int slicePosition = giveRandomValue(0, str.length()-1);
		String str1 = cut(str, 0, slicePosition);
		String str2 = cut(str, slicePosition+1, str.length()-1);

		// System.out.println(str1 + " " + str2);

		if(giveRandomValue(0,2) <= 1)
			return recPrint(str2) + recPrint(str1);
		return recPrint(str1) + recPrint(str2);		
	}
	
	public static String cut(String str, int start, int end)
	{
		String part = "";
		for(int i = start ; i <= end ; i++){
			part += str.charAt(i);
		}
		
		return part;
	}
	
	public static int giveRandomValue(int from, int to)
	{
		int r;
		do
		{
			r = (int)(Math.random() * 10);
		}while(r < from || r > to );
		
		return r;
	}
}