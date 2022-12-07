import java.util.Scanner;

class recRemoveAdjacent
{
	static StringBuffer str;
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		str = new StringBuffer(s.nextLine());
		
		str = recrem(str.length() - 2);
		System.out.println(str);
		s.close();
	}
	
	public static StringBuffer recrem(int pos)
	{
		if(pos < 0 || str.length() == 0) return new StringBuffer("");
		if(pos == 0)
		{
			if(str.charAt(0) == str.charAt(1))
				return str.delete(0,2);
		}
		
		if(str.charAt(pos) == str.charAt(pos+1))
			str = str.delete(pos, pos+2);
		
		return recrem(pos-1);
	}
}