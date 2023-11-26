package Task4;
	import java.util.Scanner;

	public class Connect4Game {

	    private static final int ROWS = 6;
	    private static final int COLUMNS = 7;
	    private static final char EMPTY_SLOT = ' ';
	    private static final char PLAYER1_SYMBOL = 'X';
	    private static final char PLAYER2_SYMBOL = 'O';

	    private char[][] board;

	    public Connect4Game() {
	        board = new char[ROWS][COLUMNS];
	        initializeBoard();
	    }

	    private void initializeBoard() {
	        for (int i = 0; i < ROWS; i++) {
	            for (int j = 0; j < COLUMNS; j++) {
	                board[i][j] = EMPTY_SLOT;
	            }
	        }
	    }

	    private void printBoard() {
	        for (int i = 0; i < ROWS; i++) {
	            for (int j = 0; j < COLUMNS; j++) {
	                System.out.print(board[i][j] + " ");
	            }
	            System.out.println();
	        }
	        System.out.println("1 2 3 4 5 6 7");
	    }

	    private boolean dropPiece(int column, char symbol) {
	        for (int i = ROWS - 1; i >= 0; i--) {
	            if (board[i][column] == EMPTY_SLOT) {
	                board[i][column] = symbol;
	                return true;
	            }
	        }
	        return false; // Column is full
	    }

	    private boolean checkWin(char symbol) {
	        // Check horizontally
	        for (int i = 0; i < ROWS; i++) {
	            for (int j = 0; j <= COLUMNS - 4; j++) {
	                if (board[i][j] == symbol && board[i][j + 1] == symbol &&
	                    board[i][j + 2] == symbol && board[i][j + 3] == symbol) {
	                    return true;
	                }
	            }
	        }

	        // Check vertically
	        for (int i = 0; i <= ROWS - 4; i++) {
	            for (int j = 0; j < COLUMNS; j++) {
	                if (board[i][j] == symbol && board[i + 1][j] == symbol &&
	                    board[i + 2][j] == symbol && board[i + 3][j] == symbol) {
	                    return true;
	                }
	            }
	        }

	        // Check diagonally (from bottom-left to top-right)
	        for (int i = 3; i < ROWS; i++) {
	            for (int j = 0; j <= COLUMNS - 4; j++) {
	                if (board[i][j] == symbol && board[i - 1][j + 1] == symbol &&
	                    board[i - 2][j + 2] == symbol && board[i - 3][j + 3] == symbol) {
	                    return true;
	                }
	            }
	        }

	        // Check diagonally (from top-left to bottom-right)
	        for (int i = 0; i <= ROWS - 4; i++) {
	            for (int j = 0; j <= COLUMNS - 4; j++) {
	                if (board[i][j] == symbol && board[i + 1][j + 1] == symbol &&
	                    board[i + 2][j + 2] == symbol && board[i + 3][j + 3] == symbol) {
	                    return true;
	                }
	            }
	        }

	        return false;
	    }

	    public void playGame() {
	        Scanner scanner = new Scanner(System.in);
	        char currentPlayer = PLAYER1_SYMBOL;

	        while (true) {
	            printBoard();
	            System.out.println("Player " + (currentPlayer == PLAYER1_SYMBOL ? "1" : "2") + ", enter your move (1-7): ");
	            int column = scanner.nextInt() - 1;

	            if (column < 0 || column >= COLUMNS || board[0][column] != EMPTY_SLOT) {
	                System.out.println("Invalid move. Try again.");
	                continue;
	            }

	            if (!dropPiece(column, currentPlayer)) {
	                System.out.println("Column is full. Try again.");
	                continue;
	            }

	            if (checkWin(currentPlayer)) {
	                printBoard();
	                System.out.println("Player " + (currentPlayer == PLAYER1_SYMBOL ? "1" : "2") + " wins!");
	                break;
	            }

	            if (isBoardFull()) {
	                printBoard();
	                System.out.println("The game is a draw!");
	                break;
	            }

	            currentPlayer = (currentPlayer == PLAYER1_SYMBOL) ? PLAYER2_SYMBOL : PLAYER1_SYMBOL;
	        }

	        scanner.close();
	    }

	    private boolean isBoardFull() {
	        for (int i = 0; i < COLUMNS; i++) {
	            if (board[0][i] == EMPTY_SLOT) {
	                return false;
	            }
	        }
	        return true;
	    }
	    
	    

	    public static void main(String[] args) {
	        Connect4Game connect4Game = new Connect4Game();
	        connect4Game.playGame();
	    }
	}

