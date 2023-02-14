import java.util.Scanner;

class NumPrinter
{
	static char[][][] nums = new char[10][][];
	
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		String printNum = s.next();
		char printChar = s.next().charAt(0);
		int width = s.nextInt() + 2;

		NumPrinter np = new NumPrinter();
		np.createNumberArray(width, printChar);
		
		for(int i = 0 ; i < printNum.length() ; i++)
		{
			if(printNum.charAt(i) < '0' || printNum.charAt(i) > '9') continue;
			
			int pos = printNum.charAt(i) - '0';
			
			for(int j = 0 ; j < 7 ; j++)
			{
				System.out.print("\t");
				for(int k = 0 ; k < width ; k++)
				{
					if(nums[pos][j][k] == 0) System.out.print(" ");
					else  System.out.print(nums[pos][j][k]);
				}
				System.out.println();
			}
			System.out.println();
			System.out.println();
		}
	}
	
	void createNumberArray(int width, char printChar)
	{
		for(int i = 0 ; i < 10 ; i++)
		{
			nums[i] = new char[7][width];
			switch(i)
			{
				case 0 : 
				{
					for(int j = 0 ; j < 7 ; j++)
					{
						for(int k = 0 ; k < width ; k++)
						{
							if(j == 0 || j == 6) nums[i][j][k] = printChar;
							if(k == 0 || k == width - 1) nums[i][j][k] = printChar;
						}
					}
					break;
				}
				case 1 : 
				{
					for(int j = 0 ; j < 7 ; j++)
					{
						for(int k = 0 ; k < width ; k++)
						{
							if(k == width - 1) nums[i][j][k] = printChar;
						}
					}
					break;
				}
				case 2 : 
				{
					for(int j = 0 ; j < 7 ; j++)
					{
						for(int k = 0 ; k < width ; k++)
						{
							if(j == 0 || j == 6 || j == 3) nums[i][j][k] = printChar;
							else if(k == 0 &&  j >= 3) nums[i][j][k] = printChar;
							else if(k == width-1 && j <= 3) nums[i][j][k] = printChar;
						}
					}
					break;
				}
				case 3 : 
				{
					for(int j = 0 ; j < 7 ; j++)
					{
						for(int k = 0 ; k < width ; k++)
						{
							if(j == 0 || j == 6 || j == 3) nums[i][j][k] = printChar;
							else if(k == width - 1) nums[i][j][k] = printChar;
						}
					}
					break;
				}
				case 4 : 
				{
					for(int j = 0 ; j < 7 ; j++)
					{
						for(int k = 0 ; k < width ; k++)
						{
							if(j == 3) nums[i][j][k] = printChar;
							if(k == width - 1) nums[i][j][k] = printChar;
							else if(k == 0 && j <= 3) nums[i][j][k] = printChar;
						}
					}
					break;
				}
				case 5 : 
				{
					for(int j = 0 ; j < 7 ; j++)
					{
						for(int k = 0 ; k < width ; k++)
						{
							if(j == 0 || j == 6 || j == 3) nums[i][j][k] = printChar;
							if(k == 0 &&  j <= 3) nums[i][j][k] = printChar;
							else if(k == width-1 && j >= 3) nums[i][j][k] = printChar;
						}
					}
					break;
				}
				case 6 : 
				{
					for(int j = 0 ; j < 7 ; j++)
					{
						for(int k = 0 ; k < width ; k++)
						{
							if(j == 0 || j == 6 || j == 3) nums[i][j][k] = printChar;
							if(k == 0) nums[i][j][k] = printChar;
							else if(k == width-1 && j >= 3) nums[i][j][k] = printChar;
						}
					}
					break;
				}
				case 7 :
				{
					for(int j = 0 ; j < 7 ; j++)
					{
						for(int k = 0 ; k < width ; k++)
						{
							if(j == 0) nums[i][j][k] = printChar;
							else if(k == width-1) nums[i][j][k] = printChar;
						}
					}
					break;
				}
				case 8 :
				{
					for(int j = 0 ; j < 7 ; j++)
					{
						for(int k = 0 ; k < width ; k++)
						{
							if(j == 0 || j == 3 || j == 6) nums[i][j][k] = printChar;
							else if(k == width-1 || k == 0) nums[i][j][k] = printChar;
						}
					}
					break;
				}
				case 9 :
				{
					for(int j = 0 ; j < 7 ; j++)
					{
						for(int k = 0 ; k < width ; k++)
						{
							if(j == 0 || j == 3 || j == 6) nums[i][j][k] = printChar;
							else if(k == width-1) nums[i][j][k] = printChar;
							else if(j <= 3 && k == 0) nums[i][j][k] = printChar;
						}
					}
					break;
				}
			}
		}
	}
}