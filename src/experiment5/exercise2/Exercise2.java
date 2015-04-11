package experiment5.exercise2;

import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Exercise2 extends JFrame 
				implements MouseListener, KeyListener {
	private static final long serialVersionUID = 1L;
	private static final int DEFAULT_NUM_OF_BUTTON = 4;
	private static final int DEFAULT_NUM_OF_LABEL = 3;
	private static final int DEFAULT_NUM_OF_TEXTFIELD = 3;
	private JButton[] buttons = new JButton[DEFAULT_NUM_OF_BUTTON];
	private JLabel[] labels = new JLabel[DEFAULT_NUM_OF_LABEL];
	private JTextField[] textFields = new JTextField[DEFAULT_NUM_OF_TEXTFIELD];
	private String[][] texts;
	
	public Exercise2() {
		setResizable(false);
		setTitle("简单的计算器");
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		texts = new String[][]{
				{"加","减","乘","除",},
				{"第一个数:","第一个数:","结果:",},};
		
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton(texts[0][i]);
			getContentPane().add(buttons[i]);
			buttons[i].addMouseListener(this);
		}

		for (int i = 0; i < labels.length; i++) {
			labels[i] = new JLabel(texts[1][i]);
			labels[i].setFont(new Font("SimSun", Font.PLAIN, 15));
			getContentPane().add(labels[i]);
		}
		
		for (int i = 0; i < textFields.length; i++) {
			textFields[i] = new JTextField();
			textFields[i].setColumns(10);
			getContentPane().add(textFields[i]);
			textFields[i].addKeyListener(this);
			textFields[i].addMouseListener(this);
		}

		labels[0].setBounds(10, 10, 76, 25);
		labels[1].setBounds(156, 10, 76, 25);
		labels[2].setBounds(309, 10, 76, 25);
		textFields[0].setBounds(80, 12, 66, 21);
		textFields[1].setBounds(229, 12, 66, 21);
		textFields[2].setBounds(352, 12, 80, 21);
		buttons[0].setBounds(29, 45, 76, 25);
		buttons[1].setBounds(134, 45, 76, 25);
		buttons[2].setBounds(239, 45, 76, 25);
		buttons[3].setBounds(344, 45, 76, 25);

		setBounds(0, 0, 459, 125);
		setLocation((getToolkit().getScreenSize().width - getWidth()) / 2,
				(getToolkit().getScreenSize().height - getHeight()) / 2);
		setVisible(true);
		textFields[2].setEditable(false);
		textFields[0].requestFocus();
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		Object clickObject = arg0.getSource();
		if (!(textFields[0].getText().equals("") 
				|| textFields[1].getText().equals(""))) {
			// 检查编辑框是否为空，防止程序抛出错误
			double num1 = Double.parseDouble(textFields[0].getText());
			double num2 = Double.parseDouble(textFields[1].getText());
			if (clickObject.equals(buttons[0])) {
				textFields[2].setText(num1 + num2 + "");
			} else if (clickObject.equals(buttons[1])) {
				textFields[2].setText(num1 - num2 + "");
			} else if (clickObject.equals(buttons[2])) {
				textFields[2].setText(num1 * num2 + "");
			} else if (clickObject.equals(buttons[3])) {
				textFields[2].setText(num1 / num2 + "");
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Object clickObject = e.getSource();
		// 设置细节，自动清空内容
		if (clickObject.equals(textFields[0])) {
			textFields[0].setText("");
			textFields[2].setText("");
		} else if (clickObject.equals(textFields[1])) {
			textFields[1].setText("");
			textFields[2].setText("");
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// 设置细节，自动切换焦点
		Object pressedObject = e.getSource();
		if (pressedObject.equals(textFields[0]) && e.getKeyCode() == 10) {
			textFields[1].requestFocus();
		}
	}

	public static void main(String[] args) {
		new Exercise2();
	}
	
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}
}
