package Chapter13_Swing;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


// 模擬FlowLayout 佈局：從左到右， 從上到下
public class PanelFlowLayout {

	public static void main(String[] args) {
		PanelFlowLayout panel = new PanelFlowLayout();
		panel.go();

	}

	public void go() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);

		// 把panel 放到框架的東側
		frame.getContentPane().add(BorderLayout.EAST, panel);

		// 添加一個button 到panel 上
		JButton btn = new JButton("Click me");// 發現panel 變寬了;
		panel.add(btn);

		// 再添加一個button
		JButton btnTwo = new JButton("Shock me");
		panel.add(btnTwo);

		// 再添加一個button
		JButton btnThree = new JButton("huh?");
		panel.add(btnThree);

		//Button 水平方向排版

		frame.setSize(300, 300);
		frame.setVisible(true);
	}

}
