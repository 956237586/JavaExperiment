package experiment5.exercise3;

import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Exercise3 extends JFrame 
					   implements MouseListener,KeyListener {
	private static final long serialVersionUID = 1L;
	private static final int DEFAULT_NUM_OF_LABEL = 4;
	private static final int DEFAULT_NUM_OF_TEXTFIELD = 4;
	private JLabel[] labels = new JLabel[DEFAULT_NUM_OF_LABEL];
	private JTextField[] textFields = new JTextField[DEFAULT_NUM_OF_TEXTFIELD];
	private JButton button = new JButton("计算投资值");
	private String[] texts;
	public Exercise3() {
		setResizable(false);
		setTitle("投资值计算器");
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		texts = new String[] { "投资总额", "投资年限", "年利率", "未来收益值", };
		

		for (int i = 0; i < labels.length; i++) {
			labels[i] = new JLabel(texts[i]);
			labels[i].setFont(new Font("SimSun", Font.BOLD, 14));
			getContentPane().add(labels[i]);
		}

		for (int i = 0; i < textFields.length; i++) {
			textFields[i] = new JTextField();
			textFields[i].setColumns(10);
			textFields[i].setHorizontalAlignment(SwingConstants.RIGHT);
			getContentPane().add(textFields[i]);
			textFields[i].addKeyListener(this);
			textFields[i].addMouseListener(this);
		}
		getContentPane().add(button);
		button.addMouseListener(this);

		labels[0].setBounds(10, 10, 113, 48);
		labels[1].setBounds(10, 68, 113, 48);
		labels[2].setBounds(10, 126, 113, 48);
		labels[3].setBounds(10, 184, 113, 48);
		textFields[0].setBounds(239, 10, 196, 47);
		textFields[1].setBounds(239, 67, 196, 47);
		textFields[2].setBounds(239, 124, 196, 47);
		textFields[3].setBounds(239, 181, 196, 47);
		button.setBounds(315, 238, 120, 38);

		setBounds(0, 0, 451, 327);
		setLocation((getToolkit().getScreenSize().width - getWidth()) / 2,
				(getToolkit().getScreenSize().height - getHeight()) / 2);
		setVisible(true);
		textFields[3].setEditable(false);
		textFields[0].requestFocus();
	}

	public void compute() {
		if(!(textFields[0].getText().equals("") 
				|| textFields[1].getText().equals("")
				|| textFields[2].getText().equals(""))){
			//检查输入值，防止程序抛出错误
			double num1 = Double.parseDouble(textFields[0].getText());
			double num2 = Double.parseDouble(textFields[1].getText());
			double num3 = Double.parseDouble(textFields[2].getText());
			double result = num1 * Math.pow(num3/ 1200.0 + 1, 12 * num2);
			DecimalFormat format = new DecimalFormat(".##");
			textFields[3].setText(format.format(result));
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		Object clickObject = arg0.getSource();
		if (clickObject.equals(button)) {
			compute();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Object clickObject = e.getSource();
		// 设置细节，自动清空内容
		if (clickObject.equals(textFields[0])) {
			textFields[0].setText("");
			textFields[3].setText("");
		} else if (clickObject.equals(textFields[1])) {
			textFields[1].setText("");
			textFields[3].setText("");
		} else if (clickObject.equals(textFields[2])) {
			textFields[2].setText("");
			textFields[3].setText("");
		}
	}

	
	@Override
	public void keyPressed(KeyEvent e) {
		// 设置细节，自动切换焦点
		Object pressedObject = e.getSource();
		if (e.getKeyCode() == 10) {
			if (pressedObject.equals(textFields[0])) {
				textFields[1].requestFocus();
				textFields[1].setText("");
			} else if (pressedObject.equals(textFields[1])) {
				textFields[2].requestFocus();
				textFields[2].setText("");
			} else if (pressedObject.equals(textFields[2])) {
				compute();
			}
		}
	}
	
	public static void main(String[] args) {
		new Exercise3();
	}
	
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}
}
