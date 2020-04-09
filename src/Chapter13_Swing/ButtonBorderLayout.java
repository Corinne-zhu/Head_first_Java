package Chapter13_Swing;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;

// 模擬BorderLayout 佈局 ： 東，西， 南，北， 中

public class ButtonBorderLayout {
	public static void main(String[] args) {
		ButtonBorderLayout button = new ButtonBorderLayout();
//		button.goEast();
//		button.goNorth();

		button.go();
	}

	// 設置Button 在左側 ： 高度不變
	public void goEast() {
		JFrame frame = new JFrame();
		JButton btn = new JButton("click like you mean it");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(BorderLayout.EAST, btn);
		frame.setSize(200, 200);
		frame.setVisible(true);
	}

	// 設置Button在北側：寬度不變
	public void goNorth() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton btn = new JButton("click like you mean it");

		// 設置更大的字體，擴大高度
		Font bigFont = new Font("serif", Font.BOLD, 28);
		btn.setFont(bigFont);

		frame.getContentPane().add(BorderLayout.NORTH, btn);
		frame.setSize(200, 200);
		frame.setVisible(true);

	}

	// 東/西/南/北/中都設置button
	// 規則是：南/北先佔位，所以東西的高度要扣除南/北的高度
	public void go() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton east = new JButton("east");
		JButton west = new JButton("west");
		JButton north = new JButton("north");
		JButton south = new JButton("south");
		JButton center = new JButton("center");

		frame.getContentPane().add(BorderLayout.EAST, east);
		frame.getContentPane().add(BorderLayout.WEST, west);
		frame.getContentPane().add(BorderLayout.NORTH, north);
		frame.getContentPane().add(BorderLayout.SOUTH, south);
		frame.getContentPane().add(BorderLayout.CENTER, center);

		frame.setSize(300, 300);
		frame.setVisible(true);
	}
}
