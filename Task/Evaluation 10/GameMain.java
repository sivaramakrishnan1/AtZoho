import java.io.*;
import java.util.Scanner;

class GameMain 
{
	static Position[] position = new Position[100];
	static Player[] players;
	static int playersCount, snakeCount, ladderCount;
	static FileOutputStream writer;
	
	public static void main(String args[]) throws Exception
	{
		GameMain Game = new GameMain();
		Game.init();
		writer.close();
	}
	
	public void init() throws Exception
	{
		Scanner s = new Scanner(System.in);
		
		// initalizing the board by assigning their board number position to the object
		for(int i=0 ; i < 100 ; i++)
		{
			position[i] = new Position(i+1);
		}
		
		snakeCount = s.nextInt();
		for(int i=0 ; i<snakeCount ; i++)
		{
			int from = s.nextInt();
			int to = s.nextInt();
			
			position[from -1].setMoveTo(to);
			
			System.out.println(" " + drawLine(from, to, "S"));
			displayBoard();			
		}
		
		ladderCount = s.nextInt();
		for(int i=0 ; i<ladderCount ; i++)
		{
			int from = s.nextInt();
			int to = s.nextInt();
			
			
			position[from - 1].setMoveTo(to);
		}
		
		playersCount = s.nextInt();
		players = new Player[playersCount];
		for(int i = 0 ; i < playersCount ; i++)
		{
			players[i]  = new Player(s.next());
		}
		
		// viewBoard();
		game();
	}
	
	public void game() throws Exception
	{
		Scanner s = new Scanner(System.in);
		writer = new FileOutputStream("Game.txt", true);
		writer.write(("Name	       From      Roll      To\n").getBytes());
		while(true)
		{
			for(int i=0 ; i < playersCount ; i++)
			{
				// int roll = rollDice();
				int roll;
				do {
					System.out.println("Rolling dice : Enter a value from 1 to 6");
					roll = s.nextInt();
				}while(roll < 1 || roll > 6);
				
				writer.write((String.format("%-15s%-10d%-10d", players[i].name, players[i].position, roll)).getBytes());
				System.out.print(players[i].name + " rolled a " + roll + " and moved from " + players[i].position);
				
				if(players[i].position + roll == 100 || players[i].position == 100) 
				{
					writer.write((String.format("100\n%s wins the game\n", players[i].name)).getBytes());
					System.out.println("to 100 \n" + players[i].name + " wins the game!");
					writer.write(("======================================\n").getBytes());
					return;
				}
				else if(players[i].position + roll > 100)
				{
					writer.write((String.format("%-10d\n", players[i].position)).getBytes());
					System.out.println(" to " + players[i].position);
					break;
				}
				int move = (position[players[i].position + roll].moveTo == -1) ? players[i].position + roll : position[players[i].position + roll].moveTo;
				
				writer.write((String.format("%-10d\n", move)).getBytes());
				System.out.println(" to " + move);
				players[i].position = move;
			}			
		}
	}
	
	
	public int rollDice()
	{
		int val = 0;
		do {
			val = (int)(Math.random() * 10.0); 
		}while(val < 1 || val > 6);
		
		return val;
	}
	
	public boolean drawLine(int from, int to, String symbol)
	{
		int[] values = {10, -10, -9, -11, 9, 11, 1, -1};
		int pos, poss = from;
		
		out : for(int i=0 ; i < values.length ; i++)
		{
			while(poss > 0 && pos < 100)
			{
				if(poss == to) {
					pos = values[i];
					break out;
				}
				poss += values[i];
			}
		}
		
		
		while(from != to)
		{
			position[from-1].symbol = symbol;
			from += pos;
		}
		
		return true;
	}
	
	public void viewBoard()
	{
		for(int i=0 ; i < 10 ; i++)
		{
			for(int j = 0 ; j < 10 ; j++)
			{
				System.out.print(position[(i*10) + j].position + " " + position[(i*10) + j].moveTo + "\t");
			}
			System.out.println();
		}
	}
	
	public void displayBoard()
	{
		for(int i=0 ; i < 10 ; i++)
		{
			System.out.println("--------------------");
			for(int j = 0 ; j < 10 ; j++)
			{
				System.out.print( "|" + position[i].symbol);
			}
			System.out.println("|");
		}
		System.out.println("--------------------");
	}
}