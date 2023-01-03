import java.util.Scanner;

class BallBrick
{
	String[][] board;
	int ballCount = 0, ballPos = 0;
	boolean[] base;
	boolean baseOnRight = true;
	
	public static void main(String args[])
	{
		BallBrick bb = new BallBrick();
		bb.initGame();
	}
	
	public void initGame()
	{
		Scanner s = new Scanner(System.in);
		System.out.print("Enter size of the NxN matrix: ");
		int size = s.nextInt();
		board = new String[size][size];
		base = new boolean[size];
		
		for(int i = 0 ; i < board.length ; i++)
		{
			for(int j = 0 ; j < board.length ; j++)
			{
				if(i == 0) {
					board[i][j] = "W ";
				}					
				else if(j == 0 || j == board.length -1)
				{
					board[i][j] = "W ";
				}
				else if(i == board.length-1) {
					if(j == (board.length / 2))
					{
						board[i][j] = "o ";
						ballPos = j;
						base[j] = true;
					}
					else 
						board[i][j] = "G ";
				}
			}
		}
		System.out.println();
		
		do {
			System.out.print("Enter the brick's position and the brick type :");
			int posx = s.nextInt(), posy = s.nextInt();
			String weight = s.next();
			if(weight.length() > 1)
				assignWeight(posx, posy, weight);
			else 
				assignWeight(posx, posy, weight + " ");
			System.out.print("Do you want to continue(Y or N)? ");			
		} while(s.next().charAt(0) == 'Y');
		
		System.out.print("Enter ball count : ");
		ballCount = s.nextInt();
		startGame();
	}
	
	public void assignWeight(int x, int y, String weight)
	{
		if((x < board.length && x > 0) && (y < board[0].length-1 && y > 0))
			if(weight != null && weight.equals("0 ")) board[x][y] = null;
			else board[x][y] = weight;
	}
	
	public void startGame()
	{
		Scanner s = new Scanner(System.in);
		
		loop : while(ballCount > -1)
		{
			updateBoard();
			printBoard();
			if(isWin())
			{
				System.out.println("You won, Hurray!");
				break loop;
			}
			if(ballCount == 0)
			{
				printBoard();
				if(isWin()) System.out.println("You won, Hurray! :-)");
				else System.out.println("You lost :-(");
				break loop;
			}
			String cmd = s.next();
			
			switch(cmd)
			{
				case "ST" :
				{
					int currpos = ballPos;
					for(int i = board.length-1 ; i > 0 ; i--)
					{
						if(board[i][currpos] != null)
						{
							if(board[i][currpos].equals("DE"))
							{
								de(i);
								break;
							}
							else if(board[i][currpos].equals("DS"))
							{
								ds(i, currpos);
								break;
							}
							else if(board[i][currpos].equals("B "))
							{
								assignWeight(i, currpos, null);
								addBase();
								break;
							}
							else if(board[i][currpos].charAt(0) >= '0' && board[i][currpos].charAt(0) <= '9')
							{
								int weight = Integer.parseInt(board[i][currpos].charAt(0) + "");
								assignWeight(i, currpos, (weight-1) + " ");
								break;
							}
							else
								direction(i, currpos);
						}
					}
					break;
				}
				
				case "LD":
				{
					int currpos = ballPos;
					for(int i = board.length-2 ; i > 0 ; i--)
					{
						currpos--;
						System.out.println("Searching : " + i + " " + currpos);
						
						if(board[i][currpos] != null)
						{
							if(board[i][currpos].equals("DE"))
							{
								de(i);
								break;
							}
							else if(board[i][currpos].equals("DS"))
							{
								ds(i, currpos);
								break;
							}
							else if(board[i][currpos].charAt(0) >= '0' && board[i][currpos].charAt(0) <= '9')
							{
								int weight = Integer.parseInt(board[i][currpos].charAt(0) + "");
								assignWeight(i, currpos, (weight-1) + " ");
								break;
							}
							else if(board[i][currpos].equals("B "))
							{
								assignWeight(i, currpos, null);
								addBase();
								break;
							}
							else if(board[i][currpos].equals("W "))
							{
								currpos = checkWall(i, 1);
								break;
							}
							else
								direction(i, currpos);
						}
					}
					if(currpos == -1)
					{
						assignWeight(board.length-1 , ballPos, "G ");
						ballPos = (board.length / 2);
						assignWeight(board.length-1 , ballPos, "o ");
					} else {
					assignWeight(board.length-1 , ballPos, "G ");
					assignWeight(board.length-1 , currpos, "o ");
					ballPos = currpos;
					}
					if(!base[ballPos])
						ballCount--;
					break;
				}
				
				case "RD" :
				{
					int currpos = ballPos;
					for(int i = board.length-2 ; i > 0 ; i--)
					{
						currpos++;
						if(board[i][currpos] != null)
						{
							if(board[i][currpos].equals("DE"))
							{
								de(i);
								break;
							}
							else if(board[i][currpos].equals("DS"))
							{
								ds(i, currpos);
								break;
							}
							else if(board[i][currpos].charAt(0) >= '0' && board[i][currpos].charAt(0) <= '9')
							{
								int weight = Integer.parseInt(board[i][currpos].charAt(0) + "");
								assignWeight(i, currpos, (weight-1) + " ");
								break;
							}
							else if(board[i][currpos].equals("B "))
							{
								assignWeight(i, currpos, null);
								addBase();
								break;
							}
							else if(board[i][currpos].equals("W "))
							{
								currpos = checkWall(i, -1);
								break;
							}
							else
								direction(i, currpos);
						}
					}
					if(currpos == -1)
					{
						assignWeight(board.length-1 , ballPos, "G ");
						ballPos = (board.length / 2);
						assignWeight(board.length-1 , ballPos, "o ");
					}
					else 
					{
					assignWeight(board.length-1 , ballPos, "G ");
					assignWeight(board.length-1 , currpos, "o ");
					ballPos = currpos;
					}
					if(!base[ballPos])
						ballCount--;
					break;
				}
				case "EX" : 
				{
					break loop;
				}
				default :
				{
					System.out.println("Invalid input.\nHelp: ST - Straight ; LD - Left Diagnol ; RD - Right diagnol ; EX - Exit");
					break;
				}
			}
		}
	}
	
	public void ds(int x, int y)
	{
		assignWeight(x, y, null);
		assignWeight(x, y-1, null);
		assignWeight(x, y+1, null);
		assignWeight(x-1, y, null);
		assignWeight(x-1, y-1, null);
		assignWeight(x-1, y+1, null);
		assignWeight(x+1, y, null);
		assignWeight(x+1, y-1, null);
		assignWeight(x+1, y+1, null);
	}
	
	public void de(int x)
	{
		for(int j = 0 ; j < board.length ; j++)
		{
			assignWeight(x, j, null);
		}
	}
	
	public boolean solve(int x, int y)
	{
		if(board[x][y] == null) return false;
		
		if(board[x][y].equals("DE"))
		{
			de(x);
			return true;
		}
		else if(board[x][y].equals("DS"))
		{
			ds(x, y);
			return true;
		}
		else if(board[x][y].charAt(0) >= '0' && board[x][y].charAt(0) <= '9')
		{
			int weight = Integer.parseInt(board[x][y].charAt(0) + "");
			assignWeight(x, y, (weight-1) + " ");
			return true;
		}
		else if(board[x][y].equals("B "))
		{
			assignWeight(x, y, null);
			addBase();
			return true;
		}
		return false;
	}
	
	public void printBoard()
	{
		for(int i = 0 ; i < board.length ; i++)
		{
			for(int j = 0 ; j < board.length ; j++)
			{
				if(board[i][j] == null) System.out.print("  ");
				else System.out.print(board[i][j]);
			}
			System.out.println();
		}
		System.out.println("Ball count is " + ballCount);
	}
	
	public void updateBoard()
	{
		for(int i = 0 ; i < board.length ; i++)
		{
			if(base[i] && board[board.length-1][i].equals("G "))
			{
				board[board.length-1][i] = "_ ";
			}
		}
	}
	
	public boolean direction(int i, int currpos)
	{
		if(board[i][currpos].equals("N "))
		{
			assignWeight(i, currpos, null);
			solve(i-1, currpos);
			return true;
		}
		else if(board[i][currpos].equals("E "))
		{
			assignWeight(i, currpos+1, null);
			solve(i-1, currpos);
			return true;
		}
		else if(board[i][currpos].equals("W "))
		{
			assignWeight(i, currpos-1, null);
			solve(i-1, currpos);
			return true;
		}
		else if(board[i][currpos].equals("S "))
		{
			assignWeight(i, currpos, null);
			solve(i-1, currpos);
			return true;
		}
		return false;
	}
	
	public int checkWall(int row, int inc)
	{
		int i;
		if(inc == 1)
			i = 1;
		else 
			i = board.length-1;
		
		for(i = i ; i > 0 && i < board.length ; i += inc)
		{
			System.out.println("Wall: " + row + " " + i);
			
			if(board[row][i] != null)
			{
				solve(row, i);
			}
		}
		
		return -1;
	}
	
	public boolean isWin()
	{
		for(int i = 1 ; i < board.length -1 ; i++)
		{
			for(int j = 1 ; j < board.length -1; j++)
			{
				if(board[i][j] != null) {
					return false;

				}
			}
		}
		return true;
	}
	
	public void addBase()
	{
		for(int i = 1 ; i < base.length ; i++)
		{
			if((base.length/2) + i < base.length && !base[(base.length/2) + i])
			{
				base[(base.length/2) + i] = true;
				return;
			}
			if((base.length/2) - i < base.length && !base[(base.length/2) - i])
			{
				base[(base.length/2) - i] = true;
				return;
			}
		}
	}
}