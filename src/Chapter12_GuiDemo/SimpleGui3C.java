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
import javax.swing.JPanel;

public class SimpleGui3C implements ActionListener {
	JFrame frame;
	JButton button;

	public static void main(String[] args) {
		SimpleGui3C gui = new SimpleGui3C();
		gui.go();

	}

	public void go() {
		this.frame = new JFrame();
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.button = new JButton("Change colors");
		this.button.addActionListener(this);

		MyDrawPanel drawPanel = new MyDrawPanel();

		this.frame.getContentPane().add(BorderLayout.SOUTH, this.button);
		this.frame.getContentPane().add(BorderLayout.CENTER,drawPanel);



		this.frame.setSize(300, 300);
		this.frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.frame.repaint();
		this.button.setText("Repaint");

	}

}

class MyDrawPanel extends JPanel {
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		GradientPaint gradient = new GradientPaint(70, 70, Color.blue, 150, 150, Color.orange); // blue 是開始的顏色, orange 是漸變後的顏色
		g2d.setPaint(gradient);
		g2d.fillOval(70, 70, 100, 100);
	}

	public void initColor(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		GradientPaint gradient = new GradientPaint(70, 70, Color.blue, 150, 150, Color.blue); // blue 是開始的顏色, orange 是漸變後的顏色
		g2d.setPaint(gradient);
		g2d.fillOval(70, 70, 100, 100);


	}
}
