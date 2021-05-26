/**
 * Represents the TicTacToe board as a 3x3 2D array.
 * @author Aaron Wang
 */
public class Board {
	// initialize the board
	private int[][] board = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
	
	// set boolean variables for the player that won, or a tie
	private boolean win1 = false;
	private boolean win2 = false;
	private boolean tie = false;
	
	private int winner = -1; // winner of the game
	private int turn = 1; // which player's turn it is
	
	/**
	 * Constructor
	 */
	public Board() {
		// Player 1 starts
		turn = 1;
	}
	
	/**
	 * Returns the board as a 2D array.
	 * @return the board.
	 */
	public int[][] getBoard() {
		return board;
	}
	
	/**
	 * Returns whose turn it is.
	 * @return whose turn it is.
	 */
	public int getTurn() {
		return turn;
	}
	
	/**
	 * Checks if either player has won, or if it is a tie, and returns the result.
	 * @return who has won. -1 if not over yet, 0 if tie, 1 if Player 1 won, 2 if Player 2 won.
	 */
	public int checkWin() {
		// check if player 1 has won
		boolean dright = board[0][0] == 1 && board[1][1] == 1 && board[2][2] == 1;
		boolean dleft = board[2][0] == 1 && board[1][1] == 1 && board[0][2] == 1;
		for (int i = 0; i < board.length; i ++) {
			boolean horizontal = board[i][0] == 1 && board[i][1] == 1 && board[i][2] == 1;
			boolean vertical = board[0][i] == 1 && board[1][i] == 1 && board[2][i] == 1;
			if (horizontal || vertical || dright || dleft) {
				win1 = true;
				winner = 1;
				break;
			}
		}
		
		if(!(win1)) {
			// check if player 2 has won
			dright = board[0][0] == 2 && board[1][1] == 2 && board[2][2] == 2;
			dleft = board[2][0] == 2 && board[1][1] == 2 && board[0][2] == 2;
			for (int i = 0; i < board.length; i ++) {
				boolean horizontal = board[i][0] == 2 && board[i][1] == 2 && board[i][2] == 2;
				boolean vertical = board[0][i] == 2 && board[1][i] == 2 && board[2][i] == 2;
				if (horizontal || vertical || dright || dleft) {
					win2 = true;
					winner = 2;
				}
			}
		}
		
		// check if there has been a tie
		if (!(win1||win2)) {
			boolean draw = true;
			for (int i = 0; i < board.length; i ++) {
				for (int j = 0; j < board[0].length; j ++) {
					if (board[i][j] == 0) {
						draw = false;
					}
				}
			}
			tie = draw;
			if(tie) {
				winner = 0;
			}
		}
		
		// return who has won
		if(!(win1||win2||tie)) {
			return -1;
		} else if (win1) {
			return 1;
		} else if (win2) {
			return 2;
		} else {
			return 0;
		}
	}
	
	
	/**
	 * Sets the indicated square as occupied by the player.
	 * @param r
	 * @param c
	 * @param player
	 */
	public void move(int r, int c, int player) {
		if(player == 1) {
			board[r][c] = 1;
			turn = 2;
		} else if (player == 2) {
			board[r][c] = 2;
			turn = 1;
		}
	}
	
	/**
	 * Resets the board.
	 */
	public void reset() {
		win1 = false;
		win2 = false;
		tie = false;
		winner = -1;
		turn = 1;
		for(int i = 0; i < 3; i ++) {
			for (int j = 0; j < 3; j ++) {
				board[i][j] = 0;
			}
		}
	}
}
