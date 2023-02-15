import java.util.Scanner;
import java.util.Random;

class Minesweeper {
	int size, mineCount;
	String theLine = "", top = "";
    int[][] board;
	boolean[][] revealed, flag;
	int moves = 0;

    public static void main(String[] args) throws Exception {
        Minesweeper obj = new Minesweeper();
		obj.init();
    }
	
	void init() throws Exception
    {
		cmdCommand("cls");
		
		System.out.print("\n\tEnter board size : ");
		Scanner s = new Scanner(System.in);
		size = s.nextInt();
        
		board = new int[size][size];
		revealed = new boolean[size][size];
		flag = new boolean[size][size];
		
		for(int i = 0 ; i < size ; i++) {
			theLine += "+-----";
			top += String.format("|%3s  ", i+1);
		}
		theLine += "+-----+";
		top += "|";
		

		
		System.out.print("\n\tEnter mine count : ");
		mineCount = s.nextInt();
		
		Random rand = new Random();
		if(mineCount >= size * size)
		{
			mineCount = rand.nextInt(size, size * size);
			System.out.println("\n\n\tMine count greater than board size, so randomly created : " + mineCount + " bombs\n\n");
			Thread.sleep(2000);
		}
		
        
        for (int i = 0; i < mineCount; i++) {
            int posx = rand.nextInt(board.length);
            int posy = rand.nextInt(board.length);
			
			if(board[posx][posy] == -1) --i;
            else board[posx][posy] = -1;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
				if(board[i][j] == -1) continue;
                if(i - 1 > -1 && j - 1 > -1 && board[i-1][j-1] == -1) board[i][j]++; // top left
				if(i - 1 > -1 && board[i-1][j] == -1) board[i][j]++; // top            
                if(i - 1 > -1 && j + 1 < board[0].length && board[i-1][j+1] == -1) board[i][j]++; // topt right

                if(i + 1 < board.length && j - 1 > -1 && board[i+1][j-1] == -1) board[i][j]++; // down left
				if(i + 1 < board.length && board[i+1][j] == -1) board[i][j]++; // down
                if(i + 1 < board.length && j + 1 < board[0].length && board[i+1][j+1] == -1) board[i][j]++; // down right
                
                if(j + 1 < board[0].length && board[i][j+1] == -1) board[i][j]++; // right
                if(j - 1 > -1 && board[i][j-1] == -1) board[i][j]++; // left                                
            }
        }

        start();
    }    
	
	void start() throws Exception
	{
		Scanner s = new Scanner(System.in);
		
		out : while(true)
		{
			if(moves == mineCount)
			{
				if(checkWin())
				{
					System.out.println("You won !!!");
					cmdCommand("color 20");
					Thread.sleep(5000);
					cmdCommand("color 07");
					break out;
				}
			}
			cmdCommand("cls");
			printBoard();
			System.out.print("\n\n\tEnter <o (open) | f (flag) | e (exit)> <row> <column> : ");
			String cmd = s.next().toLowerCase();
			if(cmd.equals("e")) 
			{
				System.out.println("Game ended");
				cmdCommand("color e0");
				Thread.sleep(2000);
				cmdCommand("color 07");
				break out;
			}
			
			int posx = s.nextInt() -1, posy = s.nextInt() -1;			
			
			if(posx >= board.length || posy >= board.length|| posx < 0 || posy < 0) 
			{
				System.out.println("Invalid input, try again");
				cmdCommand("color e0");
				Thread.sleep(2000);
				cmdCommand("color 07");
				continue;
			}
			
			if(cmd.equals("o"))
			{
				if(board[posx][posy] == -1)
				{
					revealed[posx][posy] = true;
					revealAll();
					
					System.out.println("Game over ... ");
					cmdCommand("color c0");
					Thread.sleep(2000);
					cmdCommand("color 07");
					break out;
				}
				
				else if(board[posx][posy] == 0) revealFreeSpace(posx, posy);
				else if(!revealed[posx][posy]){
					revealed[posx][posy] = true;
					flag[posx][posy] = false;
				}
				else continue;
			}
			else if(cmd.equals("f"))
			{
				if(!revealed[posx][posy])
					flag[posx][posy] = !flag[posx][posy];
			}
			else {
				System.out.println("Invalid input, try again");
				cmdCommand("color e0");
				Thread.sleep(2000);
				cmdCommand("color 07");
				continue;
			}
			
			moves++;
		}
	}
	
	void revealFreeSpace(int x, int y)
	{
		if(x < 0 || y < 0 || x >= revealed.length || y >= revealed[0].length) return;
		if(revealed[x][y] || board[x][y] == -1) return;
		
		revealed[x][y] = true;
		
		if(board[x][y] != 0) return;
		flag[x][y] = false;
		
		revealFreeSpace(x-1, y);
		revealFreeSpace(x, y-1);
		revealFreeSpace(x-1, y-1);
		revealFreeSpace(x+1, y);
		revealFreeSpace(x, y+1);
		revealFreeSpace(x+1, y+1);
		revealFreeSpace(x-1, y+1);
		revealFreeSpace(x-1, y+1);
		
	}
	
	void printBoard()
    {
		System.out.println("\t" + theLine);
		System.out.println("\t|BOOOM" + top);
        for(int i = 0 ; i < board.length ; i++)
        {
			System.out.println("\t" + theLine);
			System.out.print(String.format("\t|%3s  ", (i+1)));
			
            for (int j = 0; j < board.length; j++) {
				if(flag[i][j]) 
					System.out.print("|  f  ");
				else if(revealed[i][j] && board[i][j] == 0) 
					System.out.print("|     ");
                else if(!revealed[i][j]) 
					System.out.print(String.format("|%3s  ", "?"));
                else 
					System.out.print(String.format("|%3s  ", board[i][j]));
            }
            System.out.println("|");
        }
		System.out.println("\t" + theLine);
    }
	
	boolean checkWin()
	{
		for(int i = 0 ; i < board.length ; i++)
		{
			for(int j = 0 ; j < board.length ; j++)
			{
				if(board[i][j] != -1 && flag[i][j]) return false;
			}
		}
		
		return true;
	}
	
	void revealAll()
	{
		System.out.println("\t" + theLine);
		System.out.println("\t|!!!!!" + top);
        for(int i = 0 ; i < board.length ; i++)
        {
			System.out.println("\t" + theLine);
			System.out.print(String.format("\t|%3s  ", (i+1)));
            for (int j = 0; j < board.length; j++) {
				if(board[i][j] == 0) System.out.print("|     ");
				else if(board[i][j] == -1) System.out.print("|  *  ");
				else  System.out.print(String.format("|%3s  ", board[i][j]));
            }
            System.out.println("|");
        }
		System.out.println("\t" + theLine);
    }
	
	void cmdCommand(String str)
	{
		try {
			new ProcessBuilder("cmd", "/c", str).inheritIO().start().waitFor();
		} catch(Exception e) {
			System.out.println(e);
		}
	}

}