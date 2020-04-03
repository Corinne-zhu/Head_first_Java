package Chapter12_GuiDemo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SimpleGui1B implements ActionListener {
	// 類實現ActionListener 接口，事件會通知實現此接口的類
	JButton button;

	public static void main(String[] args) {
		SimpleGui1B gui = new SimpleGui1B();
		gui.go();

	}

	public void go() {
		JFrame frame = new JFrame("demo");
		this.button = new JButton("click me");
		this.button.addActionListener(this);  // 向按鈕註冊

		frame.getContentPane().add(this.button);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setVisible(true);

	}

	// 處理事件的方法
	@Override
	public void actionPerformed(ActionEvent e) {
		this.button.setText("I've been clicked! ");

	}

}
