import java.util.Scanner;

class ColorBalls
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		String str = s.next();
		s.close();
		
		int count = 0;
		
		for(int i = 0 ; i < str.length()-1 ; i++) {
			if(str.charAt(i) != str.charAt(i+1)) {
				count++;
				i++;
			}
		}
		System.out.println(count);
	}
}