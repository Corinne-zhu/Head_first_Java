package Chapter13_Swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

// 練習幾種常用的Swing組件：JTextField ,JTextArea
public class SwingTest {

	public static void main(String[] args) {
		SwingTest sw = new SwingTest();

		TextAreaDemo test = sw.new TextAreaDemo();
		test.go();

	}

	// JTestField
	static void testField() {
		// 構造函數
		JTextField testFiled1 = new JTextField(20); // 20字寬
		JTextField testField2 = new JTextField("Your name");

		// 取得文本內容
		System.out.println(testField2.getText());

		// 設定內容
		testField2.setText("Corinee");
		System.out.println(testField2.getText());

		// 選取文本字段的內容
		testField2.selectAll();

		// 獲得焦點
		testField2.requestFocus();

	}

	// JtextArea: 多行文本框
	static void textArea() {
		JTextArea testArea = new JTextArea(10, 20); // 10 行高， 20行寬

	}

	// JTextArea 的運用
	static void testAreaDemo() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.getContentPane().add(BorderLayout.NORTH, panel);
		panel.setBackground(Color.ORANGE);

		JTextArea testArea = new JTextArea(10, 20);
		// 增設垂直滾動條
		JScrollPane scroller = new JScrollPane(testArea);
		testArea.setLineWrap(true); // 啟動自動換行
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS); // 垂直滚动条
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER); // 不设置水平滚动条

		// 重要：加入的是帶有文本域的滾動條
		panel.add(scroller);

		// 替換文字內容
		testArea.setText("Chapter 1");

		// 加入文字
		testArea.append("\n");
		testArea.append("Chapter 2");

		// 選取內容
		testArea.selectAll();

		// 將焦點設置到控件上
		testArea.requestFocus();

		frame.setSize(300, 300);
		frame.setVisible(true);
	}

	// TextArea & Button
	// 按下button， 在textarea 中添加一行
	class TextAreaDemo implements ActionListener {
		JTextArea text;
		int row;

		void go() {
			JFrame frame = new JFrame();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			JPanel panel = new JPanel();
			frame.getContentPane().add(BorderLayout.CENTER, panel);

			JButton button = new JButton("Click here");
			frame.getContentPane().add(BorderLayout.SOUTH, button);

			this.text = new JTextArea(10, 20);
			this.text.setLineWrap(true);
			button.addActionListener(this);

			// 設置滾動條
			JScrollPane scroller = new JScrollPane(this.text);
			scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

			panel.add(scroller);
			frame.setSize(350, 300);
			frame.setVisible(true);
		}

		// 按下Button 就在TextArea 中添加一行
		@Override
		public void actionPerformed(ActionEvent e) {
			this.row++;
			this.text.append("NO. " + this.row + " : button clicked \n");

		}

	}
}
