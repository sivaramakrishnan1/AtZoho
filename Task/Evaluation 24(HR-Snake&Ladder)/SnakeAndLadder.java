import java.util.Scanner;
import java.io.*;

class SnakeAndLadder
{
	static String[][] board = new String[10][10];
	static int[] players = new int[1];
	static int[][] snake = {{40, 3}, {43, 18}, {27, 5}, {54, 31}, {89, 53}, {66, 45}, {76, 58}, {99, 41}};
	static int[][] ladder = {{25, 4}, {46, 13}, {49, 33}, {69, 50}, {63, 42}, {81, 62}, {92, 74}};
	Scanner s = new Scanner(System.in);
	
	public static void main(String args[]) throws Exception
	{
		SnakeAndLadder sal = new SnakeAndLadder();
		sal.start();
	}
	
	public void start() throws Exception
	{
		
		initialize();
		arrange();
		int pos = 0;
		
		out : while(true)
		{
			clean();
			printBoard();
			System.out.println("\n\nPlayer "+ (char)(pos % players.length + 'A') + " move : ");
			int roll = rollDice();
			if(roll == 0) break;
			else if(roll > 6 || roll < 1) continue;
			
			if(players[pos] + roll > 99)
			{
				clean();
				System.out.println("Player "+ (char)(pos % players.length + 'A') + " You won!!!");
				printBoard();
				break out;
			}
			if(!moveSnakeLadder(players[pos]+roll, pos))
				players[pos] += roll;
			
			arrange();
			pos = (pos + 1 == players.length) ? 0 : ++pos;
			// Thread.sleep(500);Thread.sleep(500);
		}
	}
	
	public boolean moveSnakeLadder(int pos, int per)
	{
		for(int i = 0 ; i < snake.length ; i++)
		{
			if(pos == snake[i][0]-1) {
				players[per] = snake[i][1]-1;
				arrange();
				return true;
			}
		}
		
		for(int i = 0 ; i < ladder.length ; i++)
		{
			if(pos == ladder[i][1]-1) {
				players[per] = ladder[i][0]-1;
				arrange();
				return true;
			}
		}
		return false;
	}
	
	public void printBoard()
	{
		for(int i = 9 ; i > -1 ; i--)
		{
			for(int j = 9; j > -1 ; j--)
			{
				System.out.print(String.format("%7s", board[i][j]));
			}
			
			System.out.println();
			System.out.println();
			i--;
			for(int j = 0; j < 10 ; j++)
			{
				System.out.print(String.format("%7s", board[i][j]));
			}			
			System.out.println();
			System.out.println();
		}
	}
	
	public void arrange()
	{
		int val = 1;
		for(int i = 0 ; i < 10 ; i++)
		{
			for(int j = 0; j < 10 ; j++)
			{
				board[i][j] = val++ + "";
			}		
		}
		
		for(int i = 0 ; i < snake.length ; i++)
		{
			board[(snake[i][0] - 1)/10][((snake[i][0] - 1)%10)] = "~S"+(i+1);
			board[(snake[i][1] - 1)/10][((snake[i][1] - 1)%10)] = "~S"+(i+1);
		}
		
		for(int i = 0 ; i < ladder.length ; i++)
		{
			board[(ladder[i][0] - 1)/10][((ladder[i][0] - 1)%10)] = "#L"+(i+1);
			board[(ladder[i][1] - 1)/10][((ladder[i][1] - 1)%10)] = "#L"+(i+1);
		}
		
		for(int i = 0 ; i < players.length ; i++)
		{
			char c = board[players[i]/10][(players[i]%10)].charAt(0);
			
			if(c >= '0' && c <= '9')
				board[players[i]/10][(players[i]%10)] = (char)(i + 'A') + "";
			else 
				board[players[i]/10][(players[i]%10)] += (char)(i + 'A') + "";
		}
	}
	public void initialize()
	{
		System.out.print("How many players : ");
		players = new int[s.nextInt()];
		
		for(int i = 0 ; i < players.length ; i++)
		{
			players[i] = 0;
		}
		
		int val = 1;
		for(int i = 0 ; i < 10 ; i++)
		{
			for(int j = 0; j < 10 ; j++)
			{
				board[i][j] = val++ + "";
			}		
		}		
	}
	
	public int rollDice()
	{
		int val;
		do 
		{
			val = (int)(Math.random() * 10);
		}while(val > 6 || val < 1);
		
		return val;
	}
	
	public void clean() throws IOException, InterruptedException
	{
		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	}
}