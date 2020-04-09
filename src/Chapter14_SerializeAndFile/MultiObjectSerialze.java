package Chapter14_SerializeAndFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

// 序列化對象中包含其他對象的引用
public class MultiObjectSerialze implements Serializable {

	private Duck duck = new Duck();

	public static void main(String[] args) throws IOException {
		MultiObjectSerialze test = new MultiObjectSerialze();

		FileOutputStream fos = new FileOutputStream("MultiObjectSerialze.ser");
		ObjectOutputStream os = new ObjectOutputStream(fos);

		os.writeObject(test);
		os.close();

	}

}
