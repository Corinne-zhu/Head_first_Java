package Chapter15_NetworkAndThread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class DailyAdviceClient {

	public static void main(String[] args) {
		DailyAdviceClient client = new DailyAdviceClient();
		client.go();

	}

	// 讀取信息
	public void go() {
		try {
			Socket s = new Socket("172.17.0.7", 1521); // mail server

			InputStreamReader isr = new InputStreamReader(s.getInputStream());

			BufferedReader reader = new BufferedReader(isr);

			String message = reader.readLine();

			System.out.println(message);

			reader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 用PrintWriter 寫到Socket 上
	public void writeToSocket() {
		try {
			Socket s = new Socket("172.17.0.17", 25);
			PrintWriter writer = new PrintWriter(s.getOutputStream());
			writer.println();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// 簡單的服務器程式
	public void socketDemo() {
		try {
			// 服務器應用程式對特定的端口創建出serverSocket
			ServerSocket serverSocket = new ServerSocket(25);

			// 客戶端對服務器應用程序建立Socket 連接
			Socket sock = new Socket("172.17.0.17", 25);

			// 服務器創建出與客戶端通信的新Socket
			Socket sock2 = serverSocket.accept();

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
