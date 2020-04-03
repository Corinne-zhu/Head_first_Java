package Chapter12_GuiDemo;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

//模拟图形移动
public class OvalMove {
	int x = 70;
	int y = 70;

	public static void main(String[] args) {

		OvalMove move  = new OvalMove();
		move.go();

	}

	public void go() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		MyDrawPanel drawPanel = new MyDrawPanel();
		frame.getContentPane().add(drawPanel);
		frame.setSize(300, 300);
		frame.setVisible(true);

		// 循環移動位置
		for (int i = 0; i < 500; i++) {
			this.x++;   // 增加坐標值
			//this.y++;

			drawPanel.repaint();

			try {
				Thread.sleep(50);  // 加上線程刻意放慢， 不然一下就會跑完，看不出動畫效果
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

	class MyDrawPanel extends JPanel {
		@Override
		public void paintComponent(Graphics g) {
			//每次畫上新的圓圈之前把整個面板用原背景色填滿，不會留下運行軌跡
			g.setColor(Color.white);
			g.fillRect(0, 0, this.getWidth(), this.getHeight());


			// 根據當前的坐標值畫面橢圓
			g.setColor(Color.blue);
			g.fillOval(OvalMove.this.x, OvalMove.this.y, 40, 40);

		}

	}
}
