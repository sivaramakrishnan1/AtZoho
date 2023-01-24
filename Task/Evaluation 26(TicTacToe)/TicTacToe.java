import java.util.Scanner;
import java.io.*;

class TicTacToe
{
	static short[][] board = new short[3][3];
	String player1, player2;
	static int moveCount = 0;
	
	public static void main(String args[]) throws Exception
	{
		TicTacToe ttt = new TicTacToe();
		ttt.init();
	}
	
	public void init() throws Exception
	{
		clear();
		Scanner s = new Scanner(System.in);
		System.out.print("\nEnter player 1 name : ");
		player1 = s.next();
		System.out.print("\nEnter player 2 name : ");
		player2 = s.next();		
		start();
	}
	
	public void start() throws Exception
	{
		Scanner s = new Scanner(System.in);
		boolean xTurn = true;
		
		while(true)
		{
			clear();
			printBoard();
				
			
			if(checkWin())
			{
				if(xTurn) System.out.println("\n\n" + player2 + " won !");
				else System.out.println("\n\n" + player1 + " won !");
				break;
			}
			if(moveCount == 9) 
			{
				System.out.println("\n\nTicTacToe Tied");
				return;
			}
			
			if(xTurn) System.out.print("\n\n" + player1 + " move : ");
			else System.out.print("\n\n" + player2 + " move : ");
			
			int x = s.nextInt(), y = s.nextInt();
			if(x == 0 && y == 0) break;
			
			if(x < 0 || x > 3 || y < 0 || y > 3) {
				for(int i = 3 ; i > 0 ; i--) {
					clear();
					System.out.println("Invlid move \n\nExiting in " + i + " seconds");
					Thread.sleep(1000);
				}
				continue;
			}
			
			if(board[x-1][y-1] != 0) {
				for(int i = 3 ; i > 0 ; i--) {
					clear();
					System.out.println("Invlid move. That place is already taken.\n\nExiting in " + i + " seconds");
					Thread.sleep(1000);
				}
				continue;
			}
			
			if(xTurn) board[x-1][y-1] = 1;
			else board[x-1][y-1] = 2;
			
			xTurn = !xTurn;	
			moveCount++;
		}
	}
	
	public boolean checkWin()
	{
		if(board[0][0] != 0 && board[0][0] == board[0][1] && board[0][0] == board[0][2]) return true;
		if(board[1][0] != 0 && board[1][0] == board[1][1] && board[1][0] == board[1][2]) return true;
		if(board[2][0] != 0 && board[2][0] == board[2][1] && board[2][0] == board[2][2]) return true;
		
		if(board[0][0] != 0 && board[0][0] == board[1][0] && board[0][0] == board[2][0]) return true;
		if(board[0][1] != 0 && board[0][1] == board[1][1] && board[0][1] == board[2][1]) return true;
		if(board[0][2] != 0 && board[0][2] == board[1][2] && board[0][2] == board[2][2]) return true;
		
		if(board[1][1] == 0) return false;
		if(board[1][1] == board[0][0] && board[1][1] == board[2][2]) return true;
		if(board[1][1] == board[2][0] && board[1][1] == board[0][2]) return true;
		
		return false;		
	}
	
	public void printBoard()
	{
		for(int i = 0 ; i < 3 ; i++)
		{
			System.out.println("+---+---+---+");
			for(int j = 0 ; j < 3 ; j++)
			{
				if(board[i][j] == 0)
					System.out.print("|   ");
				else if(board[i][j] == 1)
					System.out.print("| X ");
				else
					System.out.print("| O ");
			}
			System.out.println("|");
		}
		System.out.println("+---+---+---+");
	}
	
	public void clear() throws Exception
	{
		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();		
	}
}