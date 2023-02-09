import java.util.Scanner;

class RubicCube
{
	static char[][][] cube = new char[6][3][3];
	static int currSide = 0;
	static Scanner s = new Scanner(System.in);
	
	static {
		// ----- face 1 Red ------//
		cube[0][0][0] = 'R'; cube[0][0][1] = 'R'; cube[0][0][2] = 'R';
		cube[0][1][0] = 'R'; cube[0][1][1] = 'R'; cube[0][1][2] = 'R';
		cube[0][2][0] = 'R'; cube[0][2][1] = 'R'; cube[0][2][2] = 'R';
		
		// ----- face 2 Yellow ------//
		cube[1][0][0] = 'Y'; cube[1][0][1] = 'Y'; cube[1][0][2] = 'Y';
		cube[1][1][0] = 'Y'; cube[1][1][1] = 'Y'; cube[1][1][2] = 'Y';		
		cube[1][2][0] = 'Y'; cube[1][2][1] = 'Y'; cube[1][2][2] = 'Y';
		
		// ----- face 3 Blue ------//
		cube[2][0][0] = 'B'; cube[2][0][1] = 'B'; cube[2][0][2] = 'B';		
		cube[2][1][0] = 'B'; cube[2][1][1] = 'B'; cube[2][1][2] = 'B';		
		cube[2][2][0] = 'B'; cube[2][2][1] = 'B'; cube[2][2][2] = 'B';
		
		// ----- face 4 Green ------//
		cube[3][0][0] = 'G'; cube[3][0][1] = 'G'; cube[3][0][2] = 'G';		
		cube[3][1][0] = 'G'; cube[3][1][1] = 'G'; cube[3][1][2] = 'G';		
		cube[3][2][0] = 'G'; cube[3][2][1] = 'G'; cube[3][2][2] = 'G';
		
		// ----- face 5 White ------//
		cube[4][0][0] = 'W'; cube[4][0][1] = 'W'; cube[4][0][2] = 'W';		
		cube[4][1][0] = 'W'; cube[4][1][1] = 'W'; cube[4][1][2] = 'W';
		cube[4][2][0] = 'W'; cube[4][2][1] = 'W'; cube[4][2][2] = 'W';
		
		// ----- face 6 Orange------//
		cube[5][0][0] = 'O'; cube[5][0][1] = 'O'; cube[5][0][2] = 'O';		
		cube[5][1][0] = 'O'; cube[5][1][1] = 'O'; cube[5][1][2] = 'O';		
		cube[5][2][0] = 'O'; cube[5][2][1] = 'O'; cube[5][2][2] = 'O';
		
		
	}
	public static void main(String args[])
	{
		RubicCube rc = new RubicCube();
		System.out.println(currSide);
		rc.start();
	}
	
	void start()
	{
		out : while(true)
		{
			printCube();

			switch(s.next())
			{
				case "left" : nextMove(1); break;
				case "right" : nextMove(2); break;
				case "up" : nextMove(3); break;
				case "down" : nextMove(4); break;
				case "exit" : break out;
			} 
			
		}
	}
	
	void printCube()
	{
		for(int i = 0 ; i < 3 ; i++)
		{
			System.out.print("\t+---+---+---+\n\t");
			for(int j = 0 ; j < 3 ; j++)
			{
				System.out.print("| " + cube[currSide][i][j] + " ");
			}
			System.out.println("|");
		}
		System.out.println("\t+---+---+---+");
	}
	
	/**
	* Saves the next move of the cube. 
	@param int move
	
	move = 1 (left)
	move = 2 (up)
	move = 3 (down)
	move = 4 (right)
	*/
	void nextMove(int move)
	{
		switch(move)
		{
			// left
			case 1 :
			{
				switch(currSide)
				{
					case 0 : currSide = 4; break;
					case 1 : currSide = 4; break;
					case 2 : currSide = 4; break;
					case 3 : currSide = 4; break;
					case 4 : currSide = 2; break;
					case 5 : currSide = 0; break;
				}
			}
			break;
			
			// right		
			case 2 :
			{
				switch(currSide)
				{
					case 0 : currSide = 5; break;
					case 1 : currSide = 5; break;
					case 2 : currSide = 5; break;
					case 3 : currSide = 5; break;
					case 4 : currSide = 0; break;
					case 5 : currSide = 2; break;
				}
			}
			break;
			// up		
			case 3 :
			{
				switch(currSide)
				{
					case 0 : currSide = 3; break;
					case 1 : currSide = 0; break;
					case 2 : currSide = 1; break;
					case 3 : currSide = 2; break;
					case 4 : currSide = 3; break;
					case 5 : currSide = 3; break;
				}
			}
			break;
			// down		
			case 4 :
			{
				switch(currSide)
				{
					case 0 : currSide = 1; break;
					case 1 : currSide = 2; break;
					case 2 : currSide = 3; break;
					case 3 : currSide = 0; break;
					case 4 : currSide = 2; break;
					case 5 : currSide = 2; break;
				}
			}
			break;
		}
		System.out.println(currSide);
	}	
}