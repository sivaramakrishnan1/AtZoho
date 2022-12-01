import java.util.Scanner;

class roman 
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int val = 0;
		String rom = s.next();
		
		for(int i=0 ; i < rom.length() ; i++)
		{
			if(rom.charAt(i) == 'M')
				val += 1000;
			else if(rom.charAt(i) == 'D')
				val += 500;
			else if(rom.charAt(i) == 'C')
				val += 100;
			else if(rom.charAt(i) == 'L')
				val += 50;
			else if(rom.charAt(i) == 'X')
				val += 10;
		}
		
	
		
		System.out.println(val);			
		s.close();		
	}
}