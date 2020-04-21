package Chapter14_SerializeAndFile;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class ExternalSerialAndDeserial implements Externalizable {
	public int digit = 100;

	public static void main(String[] args) {
		ExternalSerialAndDeserial demo = new ExternalSerialAndDeserial();
		demo.digit = 1000;

		// 序列化對象
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("DeSerial.ser"));
			oos.writeObject(demo);
			oos.close();
			System.out.println(demo.digit);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 反序列化
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("DeSerial.ser"));
			ExternalSerialAndDeserial demoAfter = (ExternalSerialAndDeserial) ois.readObject();
			ois.close();
			System.out.println(demoAfter.digit);
		} catch (IOException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

	}

	// Externalizable 的序列化必須重寫這兩個方法 :writeExternal , readExternal
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeInt(this.digit);

	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		this.digit = in.readInt();

	}

}
