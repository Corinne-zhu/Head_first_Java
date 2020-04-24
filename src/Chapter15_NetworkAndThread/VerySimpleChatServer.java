package Chapter15_NetworkAndThread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

public class VerySimpleChatServer {

	ArrayList clientOutputStreams;

	// Client
	public class ClientHandler implements Runnable {
		BufferedReader reader;
		Socket sock;

		public ClientHandler(Socket clientSocket) {
			this.sock = clientSocket;
			try {
				InputStreamReader isReader = new InputStreamReader(this.sock.getInputStream());
				this.reader = new BufferedReader(isReader);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			String message;

			try {
				while ((message = this.reader.readLine()) != null) {
					System.out.println("read " + message);
					// 显示出来 .....
					VerySimpleChatServer.this.tellEveryone(message);

				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// 程式運行的功能
	public void go() {
		this.clientOutputStreams = new ArrayList();

		try {
			ServerSocket serverSock = new ServerSocket(5000);
			while (true) {
				Socket clientSock = serverSock.accept();
				PrintWriter writer = new PrintWriter(clientSock.getOutputStream());
				this.clientOutputStreams.add(writer);

				Thread t = new Thread(new ClientHandler(clientSock));
				t.start();
				System.out.println("got a connection!");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//
	public void tellEveryone(String message) {
		Iterator it = this.clientOutputStreams.iterator();

		while (it.hasNext()) {
			try {
				PrintWriter writer = (PrintWriter) it.next();
				writer.println(message);
				writer.flush();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new VerySimpleChatServer().go();
	}
}
