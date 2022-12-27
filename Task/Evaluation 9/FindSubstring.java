import java.util.Scanner;

class FindSubstring
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		
		String str = "WELCOMETOZOHOCORPORATION";
		char[][] arr = new char[5][5];
		
		int index = 0;
		
		for(int i=0 ; i<arr.length ; i++)
		{
			for(int j=0 ; j<arr[i].length ; j++)
			{
				if(index >= str.length()) break;
				arr[i][j] = str.charAt(index++);
			}
		}
		
		for(int i=0 ; i<arr.length ; i++)
		{
			for(int j=0 ; j<arr[i].length ; j++)
			{
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println("Enter the string to search : ");
		str = s.next();
		int x, y;
		out : for(int i=0 ; i<arr.length ; i++)
		{
			for(int j=0 ; j<arr[i].length ; j++)
			{
				if(arr[i][j] == str.charAt(0))
				{
					// searching top to bottom
					x = i; y = j; index = 0;
					while(x < arr.length) {
						if(index == str.length() || arr[x][y] != str.charAt(index)) 
							break;
						x++;
						index++;
					}
					
					if(index == str.length()) {
						System.out.println("TB From: " + i + " " + j + " To: " + --x + " " + y);
						break out;
					}
					
					// searching bottom to top
					x = i; y = j; index = 0;
					while(x > -1) {
						if(index == str.length() || arr[x][y] != str.charAt(index)) 
							break;
						x--;
						index++;
					}
					
					if(index == str.length()) {
						System.out.println("BT From: " + i + " " + j + " To: " + ++x + " " + y);
						break out;
					}
					
					// searching left to right
					x = i; y = j; index = 0;
					while(y < arr[i].length) {
						if(index == str.length() || arr[x][y] != str.charAt(index)) 
							break;
						y++;
						index++;
					}
					
					if(index == str.length()) {
						System.out.println("LR From: " + i + " " + j + " To: " + x + " " + --y);
						break out;
					}
					
					// searching right to left
					x = i; y = j; index = 0;
					while(y > -1) {
						if(index == str.length() || arr[x][y] != str.charAt(index)) 
							break;
						y--;
						index++;
					}
					
					if(index == str.length()) {
						System.out.println("RT From: " + i + " " + j + " To: " + x + " " + ++y);
						break out;
					}
				}
				
			}
		}
		
		s.close();
	}
}