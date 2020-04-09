package Chapter13_Swing;

import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

//練習幾種常用的Swing組件：JCheckBox
public class SwingTest2 {

	public static void main(String[] args) {
		SwingTest2 test = new SwingTest2();
		CheckBoxDemo demo = test.new CheckBoxDemo();
		demo.init();
	}

	// JCheckBox
	class CheckBoxDemo implements ItemListener {
		JCheckBox box;

		@Override
		public void itemStateChanged(ItemEvent e) {
			// 選中或改為不選中需處理的內容
			String OnOrOff = "off";
			if (this.box.isSelected()) {
				OnOrOff = "on";
			}

			System.out.println("Check box is : " + OnOrOff);
		}

		void init() {
			//JFrame
			JFrame frame = new JFrame();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			JPanel panel  = new JPanel();
			frame.getContentPane().add(BorderLayout.NORTH, panel);

			// 構造函數
			this.box = new JCheckBox("Vegetables");

			// 把CheckBox加到panel 面板中
			panel.add(this.box);

			// 監聽(被選取或非選取)
			this.box.addItemListener(this);

			// 設置默認為不選中
			this.box.setSelected(false);

			//設置frame的大小與可見
			frame.setSize(300, 300);
			frame.setVisible(true);
		}
	}
}
