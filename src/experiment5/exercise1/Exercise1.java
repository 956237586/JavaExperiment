package experiment5.exercise1;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Exercise1 extends JFrame 
					   implements MouseListener {
	private static final long serialVersionUID = 1L;
	private JButton button1 = new JButton("UP");
	private JButton button2 = new JButton("DOWN");
	private JButton button3 = new JButton("LEFT");
	private JButton button4 = new JButton("RIGHT");
	private Ball ball = new Ball(20); 
			
	public Exercise1() {
		setTitle("移动的小球");
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		button1.setBounds(170, 255, 76, 25);
		button2.setBounds(170, 284, 76, 25);
		button3.setBounds(84, 284, 76, 25);
		button4.setBounds(256, 284, 76, 25);
		Ball.setStepLong(10);
		ball.setBounds(0, 0, 419, 248);
		ball.setPosition(ball.getWidth() / 2 - ball.getRadius(),
				ball.getHeight() / 2 - ball.getRadius());
		
		button1.addMouseListener(this);
		button2.addMouseListener(this);
		button3.addMouseListener(this);
		button4.addMouseListener(this);

		getContentPane().add(button1);
		getContentPane().add(button2);
		getContentPane().add(button3);
		getContentPane().add(button4);
		getContentPane().add(ball);

		setBounds(0, 0, 435, 353);
		setLocation((getToolkit().getScreenSize().width - getWidth()) / 2,
				(getToolkit().getScreenSize().height - getHeight()) / 2);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Exercise1();
	}

	public void mouseClicked(MouseEvent arg0) {
		Object clickObject = arg0.getSource();
		if (clickObject.equals(button1)) {
			ball.move(Ball.UP);
		} else if (clickObject.equals(button2)) {
			ball.move(Ball.DOWN);
		} else if (clickObject.equals(button3)) {
			ball.move(Ball.LEFT);
		} else if (clickObject.equals(button4)) {
			ball.move(Ball.RIGHT);
		}
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

}

