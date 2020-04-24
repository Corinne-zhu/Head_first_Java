package Chapter15_NetworkAndThread;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

//簡單的聊天客戶端程序 ：只能發送的版本
public class SimpleChatClientA {
	JTextField outgoing;
	PrintWriter writer;
	Socket sock;

	// 註冊按鈕
	public void go() {
		JFrame frame = new JFrame("Ludicrously Simple Chat Client");
		JPanel mainPanel = new JPanel();
		this.outgoing = new JTextField(20);
		JButton sendBtn = new JButton("Send");

		// 為Button 註冊事件
		sendBtn.addActionListener(new SendBtnListener());

		//
		mainPanel.add(this.outgoing);
		mainPanel.add(sendBtn);
		frame.getContentPane().add(BorderLayout.CENTER, mainPanel);

		//
		this.setUpNetworking();
		frame.setSize(400, 500);
		frame.setVisible(true);
	}

	// 建立Socket 連線
	private void setUpNetworking() {
		try {
			this.sock = new Socket("172.17.0.17", 25);
			this.writer = new PrintWriter(this.sock.getOutputStream());
			System.out.println("networking established");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public class SendBtnListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// 把文本框的信息輸送到服務器上
			String data = null;
			data = SimpleChatClientA.this.outgoing.getText();

			SimpleChatClientA.this.writer.println(data);
			SimpleChatClientA.this.writer.flush();
			System.out.println(data);

			//
			SimpleChatClientA.this.outgoing.setText("");
			SimpleChatClientA.this.outgoing.requestFocus();
		}
	}

	public static void main(String[] args) {
		new SimpleChatClientA().go();
	}
}
