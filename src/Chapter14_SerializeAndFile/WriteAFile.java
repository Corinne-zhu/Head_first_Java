package Chapter14_SerializeAndFile;

import java.io.FileWriter;

//將字符串寫入文本文件中
public class WriteAFile {

	public static void main(String[] args) throws Exception {

		FileWriter writer = new FileWriter("Foo.txt");
		writer.write("hello foo!");
		writer.close();

	}

}
