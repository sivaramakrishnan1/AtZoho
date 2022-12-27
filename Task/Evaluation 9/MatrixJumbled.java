import java.util.Scanner;

class MatrixJumbled
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Size: ");
		String[] arr = new String[s.nextInt()];
		int max = 0;
		
		for(int i=0 ; i<arr.length ; i++)
		{
			arr[i] = s.next();
			max = (max < arr[i].length()) ? arr[i].length() : max;
		}
		String[] result = new String[0];
		int index = 0;
		
		for(int i=0 ; i < max ; i++) {
			String res = "", spaces = "";
			for(int j=0; j < arr.length; j++) {
				if(i < arr[j].length()) {
					res += spaces + arr[j].charAt(i);
					spaces = "";
				}
				else
					spaces += " ";				
			}
			result = add(res, result);
		}
		s.close();
		
		for(int i=0 ; i < result.length ; i++)
		{
			System.out.print("\n" + result[i]);
		}
	}
	
	public static String[] add(String str, String[] strs)
	{
		String[] copy = new String[strs.length + 1];
		for(int i = 0 ; i < strs.length ; i++)
		{
			copy[i] = strs[i];
		}
		
		strs = copy;
		copy[copy.length-1] = str;
		return copy;
	} 
}