package Chapter14_SerializeAndFile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//Serializable 序列化

public class SerialAndDeserial implements Serializable {
	public int digit = 100;

	public static void main(String[] args) {

		// 序列化之前先改變值
		SerialAndDeserial change = new SerialAndDeserial();
		change.digit = 150;

		// 序列化
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("SerialAndDeserial.ser"));
			oos.writeObject(change);
			oos.close();
			// 記錄下被序列化前的值
			System.out.println(change.digit);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 序列化之後改變值
		change.digit = 300;
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("SerialAndDeserial.ser"));
			SerialAndDeserial demo = (SerialAndDeserial) ois.readObject();
			ois.close();
			System.out.println(demo.digit);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
