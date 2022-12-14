class Chess
{
	static int[] board;
	public static void main(String args[])
	{
		board = new int[5];	
		
		for(int i = 0 ; i < board.length ; i++) {
			if(i % 2 == 0)
			{
				board[i] = i+1;
			}
			else
			{
				board[i] = i + (board.length / 2);
			}
		}
		display(board);
		
		// queen(0);
	}	
	
	public static void queen(int n)
	{
		if(n >= board.length) return;
		int pos = isValidMove(board);
		if(pos != -1)
		{
			System.out.println(pos + " " + n);
			swap(board, pos);
			queen(n);
			return;
		}
		display(board);
		queen(n+1);		
	}
	
	public static void swap(int[] board, int pos)
	{
		int temp = board[pos];
		board[pos] = board[(pos+1) % board.length];
		board[(pos+1) % board.length] = temp;		
	}
	
	public static int isValidMove(int[] board)
	{
		for(int i = 0 ; i < board.length -1 ; i++)
		{
			if(board[i] == board[i+1] + 1 || board[i] == board[i+1] - 1 )
				return i;
		}
		
		return -1;
	}

	public static void display(int[] board)
	{
		for(int i=0 ; i < board.length ; i++)
		{
			for(int j = 0 ; j < board.length ; j++)
			{
				if(board[j] - 1 == i)
					System.out.print((i+1) + " ");
				else 
					System.out.print(". ");
			}
			System.out.println();
		}
	}	
}