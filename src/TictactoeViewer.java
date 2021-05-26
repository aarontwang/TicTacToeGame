/**
 * Runs the TicTacToe game.
 * @author Aaron Wang
 */

import javax.swing.JFrame;

public class TictactoeViewer {
	
	public static void main(String[] args) {
		// create TicTacToe game and set visible
		JFrame frame = new TicTacToeGame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
	}
}
