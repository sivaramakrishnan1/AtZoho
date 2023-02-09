import java.util.Scanner;

class TicTacToe
{
	static Scanner s = new Scanner(System.in);
	static char[][] board = new char[3][3];
	
	public static void main(String args[]) throws Exception
	{
		TicTacToe ttt = new TicTacToe();
		ttt.start();
		s.nextLine();
		s.nextLine();
		ttt.clear("color 07");
	}
	
	public void start() throws Exception
	{
		int moves = 0;
		boolean isXMove = true;
		printBoard();
		while(moves < 9)
		{	
			if(isXMove) {
				System.out.print("\n\nX , make your move : ");
				clear("color 0D");
			}
			else {
				System.out.print("\n\nO , make your move : ");
				clear("color 09");
			}
			
			int pos = s.nextInt() - 1;
			
			if(pos == -1) return;
			
			if(pos < -1 || board[pos/3][pos%3] != 0) 
			{
				System.out.println("Illegal move");
				continue;
			}
			if(isXMove) board[pos/3][pos%3] = 'X';
			else board[pos/3][pos%3] = 'O';
			
			printBoard();
			if(gameEnd()) {
				clear("color 20");
				break;
			}
			
			isXMove = !isXMove;
			moves++;
		}
		
		if(moves == 9)
		{
			System.out.println("\n\nGame ended in draw");
			clear("color 40");
		}
	}
	
	boolean gameEnd()
	{
		if(board[0][0] == board[0][1] && board[0][0] == board[0][2] && board[0][0] != 0) {System.out.println("\n\n" + board[0][0] + " Won"); return true;}
		if(board[1][0] == board[1][1] && board[1][0] == board[1][2] && board[1][0] != 0) {System.out.println("\n\n" + board[1][0] + " Won"); return true;}
		if(board[2][0] == board[2][1] && board[2][0] == board[2][2] && board[2][0] != 0) {System.out.println("\n\n" + board[2][0] + " Won"); return true;}
			
		if(board[0][0] == board[1][0] && board[0][0] == board[2][0] && board[0][0] != 0) {System.out.println("\n\n" + board[0][0] + " Won"); return true;}
		if(board[0][1] == board[1][1] && board[0][1] == board[2][1] && board[0][1] != 0) {System.out.println("\n\n" + board[0][1] + " Won"); return true;}
		if(board[0][2] == board[1][2] && board[0][2] == board[2][2] && board[0][2] != 0) {System.out.println("\n\n" + board[0][2] + " Won"); return true;}
		
		if(board[1][1] != 0)
		{
			if(board[1][1] == board[0][0] && board[1][1] == board[2][2]) {System.out.println("\n\n" + board[0][0] + " Won"); return true;}
			if(board[1][1] == board[0][2] && board[1][1] == board[2][0]) {System.out.println("\n\n" + board[0][0] + " Won"); return true;}
		}
		
		return false;
	}
	
	void printBoard()
	{
		for(int i = 0 ; i < 3 ; i++)
		{
			System.out.println("+---+---+---+");
			for(int j = 0 ; j < 3 ; j++)
			{
				if(board[i][j] == 0) System.out.print("| " + ((i * 3) + j + 1) + " ");
				else System.out.print("| " + board[i][j] + " ");
			}
			System.out.println("|");
		}
		System.out.println("+---+---+---+");
	}
	
	public void clear(String cmd) throws Exception
	{
		new ProcessBuilder("cmd", "/c", cmd).inheritIO().start().waitFor();		
	}
}