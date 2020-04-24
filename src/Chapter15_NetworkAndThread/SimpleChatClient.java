package Chapter15_NetworkAndThread;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class SimpleChatClient {
	JTextArea incoming; // 接收server 信息
	JTextField outgoing; // 發送出去的信息
	BufferedReader reader;
	PrintWriter writer;
	Socket sock;

	public void go() {
		JFrame frame = new JFrame("Ludicrously Simple Chat Client");
		JPanel mainPanel = new JPanel();

		//
		this.incoming = new JTextArea(15, 50);
		this.incoming.setLineWrap(true);
		this.incoming.setWrapStyleWord(true);
		this.incoming.setEditable(false);

		//
		JScrollPane scroll = new JScrollPane(this.incoming);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		this.outgoing = new JTextField(20);

		//
		JButton sendBtn = new JButton("Send");
		sendBtn.addActionListener(new SendButtonListener());

		// 控件加入面板中
		mainPanel.add(scroll);
		mainPanel.add(this.outgoing);
		mainPanel.add(sendBtn);

		// 網絡連接
		this.setupNetworking();

		// 啟動新的線程：讀取server 的字串並顯示在文本區域上
		Thread readerThread = new Thread(new IncomingReader());
		readerThread.start();

		// 加入到frame
		frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
		frame.setSize(400, 500);
		frame.setVisible(true);
	}

	// 建立網絡連接
	public void setupNetworking() {
		try {
			this.sock = new Socket("172.17.0.17", 25);
			InputStreamReader isr = new InputStreamReader(this.sock.getInputStream());
			this.reader = new BufferedReader(isr);

			this.writer = new PrintWriter(this.sock.getOutputStream());
			System.out.println("networking established");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// Button 事件方法 : ： 把文字發送到server 上
	public class SendButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			SimpleChatClient.this.writer.println(SimpleChatClient.this.outgoing.getText());
			SimpleChatClient.this.writer.flush();

			// 清空返回的訊息欄
			SimpleChatClient.this.outgoing.setText("");
			SimpleChatClient.this.outgoing.requestFocus();
		}
	}

	public class IncomingReader implements Runnable {

		@Override
		public void run() {
			String message;
			try {
				while ((message = SimpleChatClient.this.reader.readLine()) != null) {
					System.out.println("read:  " + message);
					SimpleChatClient.this.incoming.append(message + "\n");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

	public static void main(String[] args) {
		SimpleChatClient client   = new SimpleChatClient();
		client.go();
	}

}
