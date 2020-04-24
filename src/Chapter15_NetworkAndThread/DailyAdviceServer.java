package Chapter15_NetworkAndThread;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class DailyAdviceServer {

	String[] adviceList = { "Take smaller bites", "Go for the tight jeans . No  they do not make you look fat.",
			"One word: inappropriate", "Just for today, be honest . Tell your boss what you  *really* think ",
			"You might want to rethink that haircut" };

	public static void main(String[] args) {
		DailyAdviceServer server = new DailyAdviceServer();
		server.go();
	}

	public void go() {
		try {

			// ServerSocket 會監聽客戶端對這台機器在4242端口上的要求
			ServerSocket serverSock = new ServerSocket(4242);

			// 服務器進入無限循環等待客戶端的請求
			while (true) {

				// 停下來等待要求到達之後才會繼續
				Socket sock = serverSock.accept();
				PrintWriter writer = new PrintWriter(sock.getOutputStream());
				String advice = this.getAdvice();
				writer.println(advice);
				writer.close();
				System.out.println(advice);

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// 隨機返回數組中的一個元素
	private String getAdvice() {
		int random = (int) Math.random() * this.adviceList.length;
		return this.adviceList[random];
	}

}
