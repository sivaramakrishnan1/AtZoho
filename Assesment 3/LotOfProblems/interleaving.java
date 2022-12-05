import java.util.Scanner;

class interleaving
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		String str = s.next();
		
		int size = s.nextInt();
		String[] pat = new String[size];
		
		for(int i=0 ; i < pat.length ; i++)
			pat[i] = s.next();
		
		for(int i=0 ; i < pat.length ; i++) {
			int parpat = 0;
			int parstr = 0;
			while(parpat < pat[i].length() && parstr < str.length()) {
				if(pat[i].charAt(parpat) == str.charAt(parstr)) {
					parpat++;
					parstr++;
				}
				else parstr++;
			}
			if(parpat != pat[i].length())
			{
				System.out.println("Nope");
				s.close();
				return;
			}
		}
		System.out.println("Yup");
		s.close();
		return;
	}
}