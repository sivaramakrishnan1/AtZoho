import java.util.Random;

class Minesweeper {

    static int[][] board;

    public static void main(String[] args) {
        // +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+
        init();
    }

    void printBoard()
    {
        for(int i = 0 ; i < board.length ; i++)
        {
            System.out.println("+---+---+---+---+---+---+---+---+---+");
            for (int j = 0; j < board.length; j++) {
                if(board[i][j] == 0) System.out.print("| ? ");
                else System.out.print("| " + board[i][j] + " ");
            }
            System.out.println("|");
        }
    }

    static void init()
    {
        board = new int[10][10];
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            int posx = rand.nextInt(board.length);
            int posy = rand.nextInt(board.length);
            board[posx][posy] = -1;
        }

        for (int i = 1; i < board.length - 1; i++) {
            for (int j = 1; j < board.length - 1; j++) {
                if(board[i-1][j] == -1) board[i][j]++; // top
                if(board[i-1][j-1] == -1) board[i][j]++; // top left
                if(board[i-1][j+1] == -1) board[i][j]++; // topt right

                if(board[i+1][j] == -1) board[i][j]++; // down
                if(board[i+1][j+1] == -1) board[i][j]++; // down right
                if(board[i+1][j-1] == -1) board[i][j]++; // down left

                if(board[i][j+1] == -1) board[i][j]++; // right
                if(board[i][j-1] == -1) board[i][j]++; // left                                
            }
        }
        Minesweeper obj = new Minesweeper();
        obj.printBoard();

        // obj.start();
    }


}