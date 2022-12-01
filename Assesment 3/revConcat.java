import java.util.Scanner;

class revConcat {
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		String s1 = s.next(), s2 = s.next(), s3 = "";
		
		for(int i=s2.length()-1 ; i > -1 ; i--)
			s3 += s2.charAt(i);
		
		for(int i=s1.length()-1 ; i > -1 ; i--)
			s3 += s1.charAt(i);
		
		System.out.println(s3);
		s.close();
	}
}