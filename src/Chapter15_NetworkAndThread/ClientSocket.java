package Chapter15_NetworkAndThread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

// 在本機的20006 端口建立TCP 連接
public class ClientSocket {

	public static void main(String[] args) {
		try {
			Socket client = new Socket("127.0.0.1", 20006);
			client.setSoTimeout(10000);

			// 獲取鍵盤輸入
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

			// 獲取Socket 的輸出流，用來發送數據到服務端
			PrintStream out = new PrintStream(client.getOutputStream());

			// 獲取Socket的輸入流，用來接收從服務器發送過來的數據
			BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));

			//
			boolean flag = true;
			while (flag) {
				System.out.println("--------------------- input message -------------------");
				String str = input.readLine();

				// 發送到服務端
				out.println(str);
				if ("bye".equals(str)) {
					flag = false;

				} else {
					try {
						String echo = br.readLine();
						System.out.println(echo);

					} catch (Exception e) {
						System.out.println("Time out ,NO response");

					}
				}

			}


			input.close();
			if(client!=null) {
				client.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
