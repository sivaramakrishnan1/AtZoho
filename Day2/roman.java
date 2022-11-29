import java.util.Scanner;

class roman 
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int val = s.nextInt();
		String[] values = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
		String rom = "";
		if(val == 100) System.out.println("Roman Value : C");
		else 
		{ 	
			while(val > 0)
			{
				if(val > 89) {
					rom += "XC";
					val -= 90;
				}
				else if(val > 49)
				{
					rom += "L";
					val -= 50;
				}
				else if(val > 9)
				{
					rom += "X";
					val -= 10;
				}
				else{
					rom += values[val-1];
					val -= 10;
				}
			}		
			System.out.println("Roman Value : " + rom);	
		}		
		
		s.close();		
	}
}