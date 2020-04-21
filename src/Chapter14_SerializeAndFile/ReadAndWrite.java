package Chapter14_SerializeAndFile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadAndWrite {

	public static void main(String[] args) {
		writeData();
		readData();
	}

	// 寫文件
	public static void writeData() {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("ReadAndWrite"));
			for (int i = 0; i < 10; i++) {
				writer.write("Line: " + (i + 1) + "\n");
			}

			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// 讀文件
	public static void readData() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("ReadAndWrite"));
			String line = null;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			reader.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
