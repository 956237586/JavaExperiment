package experiment5.exercise1;

import java.awt.Graphics;
import javax.swing.JPanel;

public class Ball extends JPanel {
	private static final long serialVersionUID = 1L;
	public static final int UP = 0;
	public static final int DOWN = 1;
	public static final int LEFT = 2;
	public static final int RIGHT = 3;
	public static int stepLong = 1;

	private int x;
	private int y;
	private int radius;

	public Ball(int radius) {
		this.radius = radius;
	}

	public Ball(int x, int y, int radius) {
		this(radius);
		this.x = x;
		this.y = y;
	}

	public static void setStepLong(int stepLong) {
		Ball.stepLong = stepLong;
	}

	public void move(int direction) {
		switch (direction) {
		case UP: y -= stepLong;
			break;
		case DOWN:	y += stepLong;
			break;
		case LEFT:  x -= stepLong;
			break;
		case RIGHT:	x += stepLong;
			break;
		}
		repaint();
	}

	public void  setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getRadius() {
		return radius;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawOval(x, y, 2 * radius, 2 * radius);
	}

}
