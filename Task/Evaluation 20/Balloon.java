import java.util.Scanner;
import java.util.InputMismatchException;

class Balloon {
	Scanner s = new Scanner(System.in);
	char[][] board; // this is the board

	public static void main(String args[]) {
		Balloon balloon = new Balloon();
		balloon.createBoard();
		balloon.s.close();
	}

	public void createBoard() {
		System.out.println("Enter the number of columns of the board: ");
		int col = s.nextInt();
		System.out.println("Enter the number of rows of the board: ");
		int row = s.nextInt();

		board = new char[row][col];
		start();
	}

	public void printBoard() {
		System.out.println("Contents of the matrix");
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 0)
					System.out.print("_ ");
				else
					System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void start() {
		printBoard();

		loop: while (true) {
			try {
				System.out.print("\nEnter the column number : ");
				int col = s.nextInt();
				System.out.print("\nEnter the color of the balloon : ");
				char color = s.next().toUpperCase().charAt(0);

				if (dropBalloon(col - 1, color)) {
					printBoard();
					System.out.println("*** Game over ***");
					break loop;
				}
				printBoard();

				System.out.print("\nDo you want to continue(Y/N)");
				if (s.next().equalsIgnoreCase("N")) {
					break loop;
				}
			} catch (InputMismatchException e) {
				System.out.println("Please enter the right value for the given query : " + e);
				continue;
			} catch (Exception e) {
				System.out.println("That's weird, lemme work on that: " + e);
				continue;
			}
		}

	}

	public boolean dropBalloon(int col, char color) {
		for (int i = board.length - 1; i > -1; i--) {
			if (board[i][col] == 0) {
				board[i][col] = color;
				if (i == 0)
					checkToBurst(col, color);
				return false;
			} else {
				// insertAtEmpty(col, color);
				for (int j = 0; j < board[i].length; j++) {
					if (board[i][j] == 0) {
						board[i][j] = color;
						if (i == 0)
							checkToBurst(j, color);
						return false;
					}
				}
			}
		}

		return true;
	}

	public void checkToBurst(int col, char color) {
		char bal = board[0][col];
		for (int i = 0; i < board.length; i++)
			if (bal != board[i][col])
				return;

		printBoard();

		for (int i = 0; i < board.length; i++)
			board[i][col] = 0;
	}
}