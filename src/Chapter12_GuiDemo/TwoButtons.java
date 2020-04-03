package Chapter12_GuiDemo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

// 利用內部類實現兩個button
public class TwoButtons {
	JFrame frame;
	JLabel label;

	public static void main(String[] args) {
		TwoButtons gui = new TwoButtons();
		gui.go();
	}

	public void go() {
		this.frame = new JFrame();
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton labelButton = new JButton("Change Label");
		labelButton.addActionListener(new LabelListener());

		JButton colorButton = new JButton("Change Circle");
		colorButton.addActionListener(new ColorListener());

		this.label = new JLabel("I'm a label");
		MyDrawPanel drawPanel = new MyDrawPanel();

		this.frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
		this.frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
		this.frame.getContentPane().add(BorderLayout.EAST, labelButton);
		this.frame.getContentPane().add(BorderLayout.WEST, this.label);

		this.frame.setSize(300, 300);
		this.frame.setVisible(true);
	}

	class MyDrawPanel extends JPanel {
		@Override
		public void paintComponent(Graphics g) {
			Graphics2D g2d = (Graphics2D) g;
			GradientPaint gradient = new GradientPaint(70, 70, Color.blue, 150, 150, Color.orange); // blue 是開始的顏色,
																									// orange 是漸變後的顏色
			g2d.setPaint(gradient);
			g2d.fillOval(70, 70, 100, 100);
		}
	}

	class LabelListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			TwoButtons.this.label.setText("Ouch!");
		}
	}

	class ColorListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			TwoButtons.this.frame.repaint(); // 內部類可以存取外部類的成員變量
		}
	}
}
