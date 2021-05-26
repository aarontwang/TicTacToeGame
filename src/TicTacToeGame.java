/**
 * Contains game logic for user to play the game.
 * Draws the board and allows user to select squares by pressing.
 * @author Aaron Wang
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;

public class TicTacToeGame extends JFrame {
	
	private JLabel announceWin; // declare new JLabel with information about game
	private JButton reset; // declare new JButton that restarts the game if clicked
	private LineComponent scene1; // declare new LineComponent that draws game
	private Board board; // declare new Board that contains TicTacToe board
	private static final int FRAME_WIDTH = 400; // set frame width
	private static final int FRAME_HEIGHT = 420; // set frame height
	
	class MousePressListener implements MouseListener {
		
		/**
		 * if user presses the mouse
		 */
		public void mousePressed (MouseEvent event) {
			// if the game is not over, find which square the user pressed
			if(board.checkWin()==-1) {
				int x = -1, y = -1;
				if(event.getX()>50 && event.getX()<150 && event.getY()>10 && event.getY()<110) {
					x = 0;
					y = 0;
				} else if(event.getX()>150 && event.getX()<250 && event.getY()>10 && event.getY()<110) {
					x = 0;
					y = 1;
				} else if(event.getX()>250 && event.getX()<350 && event.getY()>10 && event.getY()<110) {
					x = 0;
					y = 2;
				} else if(event.getX()>50 && event.getX()<150 && event.getY()>110 && event.getY()<210) {
					x = 1;
					y = 0;
				} else if(event.getX()>150 && event.getX()<250 && event.getY()>110 && event.getY()<210) {
					x = 1;
					y = 1;
				} else if(event.getX()>250 && event.getX()<350 && event.getY()>110 && event.getY()<210) {
					x = 1;
					y = 2;
				} else if(event.getX()>50 && event.getX()<150 && event.getY()>210 && event.getY()<310) {
					x = 2;
					y = 0;
				} else if(event.getX()>150 && event.getX()<250 && event.getY()>210 && event.getY()<310) {
					x = 2;
					y = 1;
				} else if(event.getX()>250 && event.getX()<350 && event.getY()>210 && event.getY()<310) {
					x = 2;
					y = 2;
				}
				
				// if the user pressed inside a square
				if(x!=-1 && y!=-1) {
					// if the square is occupied, ask user to choose a different square
					if (board.getBoard()[x][y]!=0) {
						announceWin.setText("Please choose an unoccupied square.");
					} else {
						// set the square to the user's icon (X or O), and draw the board
						announceWin.setText("");
						if (board.getTurn()==1) {
							scene1.drawX(x, y);
						} else if (board.getTurn()==2) {
							scene1.drawO(x, y);
						}
						board.move(x, y, board.getTurn());
						repaint();
						
						// display who won, if necessary
						if(board.checkWin()==0) {
							announceWin.setText("TIE");
						} else if (board.checkWin()==1) {
							announceWin.setText("PLAYER 1 WINS");
						} else if (board.checkWin()==2) {
							announceWin.setText("PLAYER 2 WINS");
						} else {
							announceWin.setText("TURN: PLAYER " + board.getTurn());
						}
					}
				}
			}
		}
		
		public void mouseReleased (MouseEvent event) {}
		public void mouseClicked (MouseEvent event) {}
		public void mouseEntered (MouseEvent event) {}
		public void mouseExited (MouseEvent event) {}
		
	}

	/**
	 * Create the frame.
	 */
	public TicTacToeGame() {
		// set absolute layout
		getContentPane().setLayout(null);
		
		// instantiate the JLabel with information about game
		announceWin = new JLabel("TURN: PLAYER 1");
		announceWin.setFont(new Font("Tahoma", Font.BOLD, 14));
		announceWin.setHorizontalAlignment(SwingConstants.CENTER);
		announceWin.setBounds(50, 320, 300, 20);
		getContentPane().add(announceWin);
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		
		// instantiate the LineComponent that draws the game
		scene1 = new LineComponent();
		scene1.setBounds(0, 0, 400, 310);
		getContentPane().add(scene1);
		
		// instantiate JButton 
		reset = new JButton("Restart");
		// restarts the game if clicked
		reset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				scene1.reset();
				board.reset();
				announceWin.setText("TURN: PLAYER 1");
				repaint();
			}
		});
		reset.setBounds(150, 350, 100, 20);
		getContentPane().add(reset);
		
		// add the MouseListener to the LineComponent
		MouseListener listener = new MousePressListener();
		scene1.addMouseListener(listener);
		
		// instantiate the board
		board = new Board();
	}
}
