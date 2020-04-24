package Chapter15_NetworkAndThread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

//網絡連接的步驟：建立socket 連接   --> 使用輸入流讀取數據
public class NetworkDemo {

	public static void main(String[] args) throws UnknownHostException, IOException {

	}

	// 從server 端讀取資料(採用InputStreamReader)
	public static String readFromServer() throws UnknownHostException, IOException {
		// 建立對服務器Socket 連接
		Socket charSocket = new Socket("172.17.2.103", 5000);

		// 新增連接到Socket的輸入流
		InputStreamReader isr = new InputStreamReader(charSocket.getInputStream());

		// 用緩衝流來讀取Server端數據， 提高執行效率
		BufferedReader reader = new BufferedReader(isr);

		// 獲取讀出的字符串
		String message = reader.readLine();

		return message;
	}

	// 從Server 端讀取資料(採用PrintWriter)
	public static void writeToSocket() throws UnknownHostException, IOException {
		// 建立對服務器Socket 連接
		Socket charSocket = new Socket("172.17.2.103", 5000);

		// 建立鏈接到Socket 的PrintWriter
		PrintWriter writer  = new PrintWriter(charSocket.getOutputStream());

	}

}
