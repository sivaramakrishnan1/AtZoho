import java.util.Scanner;

class ZigZag
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int row = s.nextInt();
		String str = s.next();
		s.close();
		ZigZag obj = new ZigZag();
		
		System.out.println(obj.convert(str, row));
	}
	
	public String convert(String str, int row) {
		if(row == 1) return str;
		
        String res = "";
        int offset = (row - 1) + (row - 2) + 1;
		
		for(int i = 0 ; i < row ; i++)
		{
			for(int j = 0 ; j < str.length() ; j += offset)
			{
				if(i == 0)
					// System.out.print(str.charAt(j));
					res += str.charAt(j);
				else if(i != row -1 && j < str.length()) {
					if (j - i >= 0) 
						res +=  str.charAt(j - i);
						// System.out.print(str.charAt(j - i));
					if (j + i < str.length()) 
						res += str.charAt(j + i);
						// System.out.print(str.charAt(j + i));
				}
				else if((j + i) < str.length())
				{ 
					res += str.charAt(j + i);
				}
			}
			// res += "\n";
			// System.out.println();
		}

        return res;
    }
}