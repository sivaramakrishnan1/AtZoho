import java.util.Scanner;

class stringRotate
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		
		String str = s.next(), rot = s.next();
		
		if(str.length() != rot.length()) {
			System.out.println("False");
			return;
		}
		
		int pos = -1;
		
		for(int i=0 ; i < str.length() ; i++) {
			if(str.charAt(0) == rot.charAt(i)) {
				pos = i;
				break;
			}
		}
		
		if(pos == -1) {
			System.out.println("False");
			return;
		}
		
		for(int i = 0 ; i < str.length() ; i++)
		{
			int curr = (i + pos) % str.length();
			System.out.println(str.charAt(curr) + " " + rot.charAt(i) + " " + pos);
			if(str.charAt(i) != rot.charAt(curr)) {
				System.out.println("False");
				return;
			}
		}		
		System.out.println("True");
		
	}
}