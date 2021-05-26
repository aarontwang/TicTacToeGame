/**
 * Draws the TicTacToe board, as well as the X's and O's placed by the players.
 * @author Aaron Wang
 */
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Ellipse2D.Double;
import java.awt.geom.Ellipse2D;
import javax.swing.JComponent;
import java.util.ArrayList;

public class LineComponent extends JComponent {
	
	private Line2D.Double h1; // first horizontal line
	private Line2D.Double h2; // second horizontal line
	private Line2D.Double v1; // first vertical line
	private Line2D.Double v2; // second vertical line 
	private ArrayList<Line2D.Double[]> x; // ArrayList of Arrays of lines that make up the X's
	private ArrayList<Ellipse2D.Double> o; // ArrayList of Ellipses that are the O's
	
	public LineComponent() {
		// instantiate the grid
		h1 = new Line2D.Double(new Point2D.Double(50, 110), new Point2D.Double(350, 110));
		h2 = new Line2D.Double(new Point2D.Double(50, 210), new Point2D.Double(350, 210));
		v1 = new Line2D.Double(new Point2D.Double(150, 10), new Point2D.Double(150, 310));
		v2 = new Line2D.Double(new Point2D.Double(250, 10), new Point2D.Double(250, 310));
		
		// instantiate the ArrayLists of X's and O's
		x = new ArrayList<Line2D.Double[]>();
		o = new ArrayList<Ellipse2D.Double>();
	}
	
	/**
	 * Draws an X at the specified square.
	 * @param x The row that the X will be placed in.
	 * @param y The column that the X will be placed in.
	 */
	public void drawX(int x, int y) {
		if (x == 0) {
			if (y == 0) {
				Line2D.Double[] temp = {new Line2D.Double(new Point2D.Double(50, 10), new Point2D.Double(150, 110)), new Line2D.Double(new Point2D.Double(50, 110), new Point2D.Double(150, 10))};
				this.x.add(temp);
			} else if (y == 1) {
				Line2D.Double[] temp = {new Line2D.Double(new Point2D.Double(150, 10), new Point2D.Double(250, 110)), new Line2D.Double(new Point2D.Double(150, 110), new Point2D.Double(250, 10))};
				this.x.add(temp);
			} else if (y == 2) {
				Line2D.Double[] temp = {new Line2D.Double(new Point2D.Double(250, 10), new Point2D.Double(350, 110)),new Line2D.Double(new Point2D.Double(250, 110), new Point2D.Double(350, 10))};
				this.x.add(temp);
			}
		} else if (x == 1) {
			if (y == 0) {
				Line2D.Double[] temp = {new Line2D.Double(new Point2D.Double(50, 110), new Point2D.Double(150, 210)), new Line2D.Double(new Point2D.Double(50, 210), new Point2D.Double(150, 110))}; 
				this.x.add(temp);
			} else if (y == 1) {
				Line2D.Double[] temp = {new Line2D.Double(new Point2D.Double(150, 110), new Point2D.Double(250, 210)), new Line2D.Double(new Point2D.Double(150, 210), new Point2D.Double(250, 110))}; 
				this.x.add(temp);
			} else if (y == 2) {
				Line2D.Double[] temp = {new Line2D.Double(new Point2D.Double(250, 110), new Point2D.Double(350, 210)), new Line2D.Double(new Point2D.Double(250, 210), new Point2D.Double(350, 110))}; 
				this.x.add(temp);
			}
		} else if (x == 2) {
			if (y == 0) {
				Line2D.Double[] temp = {new Line2D.Double(new Point2D.Double(50, 210), new Point2D.Double(150, 310)), new Line2D.Double(new Point2D.Double(50, 310), new Point2D.Double(150, 210))}; 
				this.x.add(temp);
			} else if (y == 1) {
				Line2D.Double[] temp = {new Line2D.Double(new Point2D.Double(150, 210), new Point2D.Double(250, 310)), new Line2D.Double(new Point2D.Double(150, 310), new Point2D.Double(250, 210))}; 
				this.x.add(temp);
			} else if (y == 2) {
				Line2D.Double[] temp = {new Line2D.Double(new Point2D.Double(250, 210), new Point2D.Double(350, 310)), new Line2D.Double(new Point2D.Double(250, 310), new Point2D.Double(350, 210))};
				this.x.add(temp);
			}
		} 
	}
	
	/**
	 * Draws an O at the specified square.
	 * @param x The row that the O will be placed in.
	 * @param y The column that the O will be placed in.
	 */
	public void drawO(int x, int y) {
		if (x==0) {
			if (y==0) {
				this.o.add(new Ellipse2D.Double(50, 10, 100, 100));
			} else if (y==1) {
				this.o.add(new Ellipse2D.Double(150, 10, 100, 100));
			} else if (y==2) {
				this.o.add(new Ellipse2D.Double(250, 10, 100, 100));
			}
		} else if (x==1) {
			if (y==0) {
				this.o.add(new Ellipse2D.Double(50, 110, 100, 100));
			} else if (y==1) {
				this.o.add(new Ellipse2D.Double(150, 110, 100, 100));
			} else if (y==2) {
				this.o.add(new Ellipse2D.Double(250, 110, 100, 100));
			}
		} else if (x==2) {
			if (y==0) {
				this.o.add(new Ellipse2D.Double(50, 210, 100, 100));
			} else if (y==1) {
				this.o.add(new Ellipse2D.Double(150, 210, 100, 100));
			} else if (y==2) {
				this.o.add(new Ellipse2D.Double(250, 210, 100, 100));
			}
		}
	}
	
	/**
	 * Clears the board.
	 */
	public void reset() {
		x.clear();
		o.clear();
	}
	
	/**
	 * Draws the board.
	 */
	public void paintComponent(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g;
		// draws the grid
		g2.draw(h1);
		g2.draw(h2);
		g2.draw(v1);
		g2.draw(v2);
		
		// draws the X's
		for(int i = 0; i < x.size(); i ++) {
			g2.draw(x.get(i)[0]);
			g2.draw(x.get(i)[1]);
		}
		
		// draws the O's
		for(int i = 0; i < o.size(); i ++) {
			g2.draw(o.get(i));
		}
	}
}
