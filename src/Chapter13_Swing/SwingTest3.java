package Chapter13_Swing;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

//練習幾種常用的Swing組件：JList
public class SwingTest3 {

	public static void main(String[] args) {
		SwingTest3 test = new SwingTest3();
		JListDemo demo = test.new JListDemo();
		demo.init();

	}

	class JListDemo implements ListSelectionListener {

		JList<String> strList;

		// 處理事件方法: 打印出選中的資料
		@Override
		public void valueChanged(ListSelectionEvent e) {
			if (!e.getValueIsAdjusting()) {
				String selectedValue = this.strList.getSelectedValue();
				System.out.println(selectedValue);
			}
		}

		void init() {
			String[] data = { "one", "two", "three", "four", "five", "six" };
			this.strList = new JList<String>(data);
			// 設定顯示的行數
			this.strList.setVisibleRowCount(5);

			// 限制用戶只能選取一個項目
			this.strList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

			// 註冊事件
			this.strList.addListSelectionListener(this);

			// 創建JFrame
			JFrame frame = new JFrame();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			// 創建panel 面板
			JPanel panel = new JPanel();
			frame.getContentPane().add(BorderLayout.NORTH, panel);

			// 創建一個滾動條並把此滾動條加到JList
			JScrollPane scroller = new JScrollPane(this.strList);
			scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

			// 將含有滾動條的JList 加入到panel 中
			panel.add(scroller);

			// 設置frame 可見
			frame.setSize(300, 300);
			frame.setVisible(true);
		}
	}
}
