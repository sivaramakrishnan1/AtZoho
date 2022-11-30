import java.util.Scanner;

class conversion 
{
	char[] hexTable = {'1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
	
	public static void main(String args[]) 
	{
		Scanner s = new Scanner(System.in);
		
		conversion con = new conversion();
		boolean loop = true;
		
		while(loop)
		{
			System.out.println("From ... ");
			System.out.println("1. Binary\n2. Octal\n3. Decimal\n4. Hexadecimal");
			int from = s.nextInt();
			if(from > 4 || from < 0)
			{
				System.out.println("Not an option");
				return;
			}
			System.out.println("1. Binary\n2. Octal\n3. Decimal\n4. Hexadecimal");
			int to = s.nextInt();
			
			if(to > 4 || to < 0)
			{
				System.out.println("Not an option");
				return;
			}
			
			int val = s.nextInt();
			switch(from)
			{
				// Binary to ...
				case 1 : 
				{
					switch(to)
					{
						case 1 : { System.out.println(val); break;}
						case 2 : { System.out.println(con.toOct(con.binToDec(val))); break;}
						case 3 : { System.out.println(con.binToDec(val)); break;}
						case 4 : { System.out.println(con.toHex(con.binToDec(val))); break;}
					}
					break;
				}
				// Octal to ...
				case 2 : 
				{
					switch(to)
					{
						case 1 : { System.out.println(con.toBin(con.octToDec(val))); break;}
						case 2 : { System.out.println(val); break;}
						case 3 : { System.out.println(con.octToDec(val)); break;}
						case 4 : { System.out.println(con.toHex(con.octToDec(val))); break;}
					}	
					break;					
				}

				// Decimal to ...
				case 3 :
				{
					switch(to)
					{
						case 1 : { System.out.println(con.toBin(val)); break;}
						case 2 : { System.out.println(con.toOct(val)); break;}
						case 3 : { System.out.println(val); break;}
						case 4 : { System.out.println(con.toHex(val)); break;}
					}	
					break;
				}
				
				// Hexadecimal to ...
				case 4 :
				{
					String hexVal = String.valueOf(val);
					switch(to)
					{
						case 1 : { System.out.println(con.toBin(con.hexToDec(hexVal))); break;}
						case 2 : { System.out.println(con.hexToDec(hexVal)); break;}
						case 3 : { System.out.println(con.toOct(con.hexToDec(hexVal))); break;}
						case 4 : { System.out.println(con.toHex(con.hexToDec(hexVal))); break;}
					}	
					break;
				}	
				
				default :
				
			}
		}
		s.close();
	}
	
	public int binToDec(int bin)
	{
		int dec = 0, lim = 1, pow = 1;
		
		while(bin > 0)
		{
			if(bin%10 == 1)
				dec += pow;
				
			bin /= 10;
			pow *= 2;
			
		}
		System.out.println(dec);

		return dec;		
	}
	
	public int octToDec(int oct)
	{
		int dec = 0, pow = 1;
		
		while(oct > 0)
		{
			/* if(pow == 0)
			{
				dec += (oct % 10) * 8;
				pow = 1;
				oct /= 10;
				continue;
			} */
			dec += (oct%10) * (8 * pow);
			pow *= 8;
			oct /= 10;
		}
		System.out.println(dec);
		
		return dec;		
	}
	
	public int hexToDec(String hex)
	{
		int dec = 0, pow = 0;
		
		for(int i=hex.length(); i>0 ; i--)
		{
			char ch = hex.charAt(i-1);
			if(ch <= '0' && ch >= '9') dec += (ch - 55) * (16 * pow);
			else dec += (ch - '0') * (16 * pow);
			pow = (pow == 0) ? 1 : 16 * pow;
		}
		System.out.println(dec);

		return dec;
	}
	
	public int toBin(int dec)
	{
		int bin = 0, lim = 1;
		
		while(dec > 0)
		{
			bin += (dec % 2) * lim;
			dec /= 2;
			lim *= 10;
		}		
		return bin;
	}
	
	public int toOct(int dec)
	{
		int lim = 1, oct = 0, carry = 0, add = 0;
		
		while(dec > 0)
		{
			oct += (dec % 8 ) * lim;
			dec /= 8;
			lim *= 10;
			System.out.println("Dec " + dec + " Oct " + oct);
		} 		
		return oct;
	}
	
	public String toHex(int dec)
	{		
		String hex = "";
		
		while(dec > 0)
		{
			hex = hexTable[(dec % 16) - 1] + hex ;
			dec /= 16;
		}
		return hex;
	} 
}