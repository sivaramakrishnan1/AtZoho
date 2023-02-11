import java.util.Scanner;

class SnakeGame
{
	static Scanner s = new Scanner(System.in);
	static char[][] board = new char[40][80];
	int headx = 20, heady = 10, tailx = 20, taily = 5;
	
	{
		board[20][10] = '>';
		board[20][9] = '>';
		board[20][8] = '>';
		board[20][7] = '>';
		board[20][6] = '>';
		board[20][5] = '>';
	}
	
	public static void main(String args[]) throws Exception
	{
		SnakeGame sg = new SnakeGame();
		sg.start();
	}
	
	public void start() throws Exception
	{		
		out : while(true)
		{
			clearScreen();
			Thread.sleep(69);
			printBoard();
			String input = s.next();
			
			for(int i = 0 ; i < input.length() ; i++)
			{
				switch(input.charAt(i))
				{
					case 'q' : break out;
					case 'w' : {
						if(snakeUp()) {
							lostGame();
							break out;
						}
						break;
					}
					case 'a' : {
						if(snakeLeft()) {
							lostGame();
							break out;
						}
						break;
					}
					case 'd' : {
						if(snakeRight()) {
							lostGame();
							break out;
						}
						break;
					}
					case 's' : {
						if(snakeDown()) {
							lostGame();
							break out;
						}
						break;
					}
				}
			}	
			
		}
	}
	
	private void lostGame()
	{
		clearScreen();
		System.out.println(String.format("%4750s%-5000s", "You lost.", "."));
	}
	
	public void printBoard()
	{
		System.out.println("\t+----------------------------------------------------------------------------------------------------------------------------------------------------------------+");
		for(int i = 0 ; i < board.length ; i++)
		{
			System.out.print("\t|");
			for(int j = 0 ; j < board[0].length ; j++)
			{
				if(board[i][j] == 0) System.out.print("  ");
				else System.out.print(board[i][j]+ " ");
			}
			System.out.println("|");
		}
		System.out.println("\t+----------------------------------------------------------------------------------------------------------------------------------------------------------------+");
	}
	
	private boolean snakeUp()
	{
		if(board[headx-1][heady] != 0 && board[headx-1][heady] != '#')
			return true;
		if(headx - 1 < 0) {
			headx = 79;
			return false;
		}
		headx--;
		board[headx][heady] = '^';
		board[tailx][taily] = 0;
		tailFollowUp();	
		return false;		
	}
	
	private boolean snakeDown()
	{
		if(board[headx+1][heady] != 0 && board[headx+1][heady] != '#')
			return true;
		if(heady + 1 == 39) {
			heady = 0;
			tailFollowUp();
			return false;
		}
		headx++;
		board[headx][heady] = 'v';
		board[tailx][taily] = 0;
		tailFollowUp();		
		return false;	
	}
	
	private boolean snakeRight()
	{
		if(board[headx][heady+1] != 0 && board[headx][heady+1] != '#')
			return true;
		if(heady + 1 == 79) {
			heady = 0;
			tailFollowUp();
			return false;
		}
		heady++;
		board[headx][heady] = '>';
		board[tailx][taily] = 0;
		tailFollowUp();		
		return false;	
	}
	
	private boolean snakeLeft()
	{
		if(board[headx][heady-1] != 0 && board[headx][heady-1] != '#')
			return true;
		if(heady - 1 == 0) {
			heady = 79;
			tailFollowUp();
			return false;
		}
		heady--;
		board[headx][heady] = '<';
		board[tailx][taily] = 0;
		tailFollowUp();	
		return false;
	}
	
	private void tailFollowUp()
	{
		if(taily - 1 == 0) taily = 79;
		if(tailx - 1 == 0) tailx = 39;
		if(tailx + 1 == 79) tailx = 0;
		if(taily + 1 == 39) taily = 0;
		
		if(board[tailx-1][taily] == '>' || board[tailx-1][taily] == '^' || board[tailx-1][taily] == '<' || board[tailx-1][taily] == 'v') tailx--;
		else if(board[tailx][taily-1] == '>' || board[tailx][taily-1] == '^' || board[tailx][taily-1] == '<' || board[tailx][taily-1] == 'v') taily--;
		else if(board[tailx][taily+1] == '>' || board[tailx][taily+1] == '^' || board[tailx][taily+1] == '<' || board[tailx][taily+1] == 'v') taily++;
		else if(board[tailx+1][taily] == '>' || board[tailx+1][taily] == '^' || board[tailx+1][taily] == '<' || board[tailx+1][taily] == 'v') tailx++;
	}
	
	public void clearScreen()
	{
		try {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} catch (Exception e) {
			
		}
	}
}