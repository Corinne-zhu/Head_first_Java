package Chapter14_SerializeAndFile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

// 驗證：不使用序列化ID 是否會有問題？

public class ObjSerializeAndDeserializeTest {

	public static void main(String[] args) {
		deserialPerson(); // person 類增加實例變量： name , address, 用原來的序列化對象進行反序列化就會報錯
		// error message :(InvalidClassException) local class incompatible: stream
		// classdesc serialVersionUID = -6176448314907969837, local class
		// serialVersionUID = -3241517977665588852

		// 解決方案：Person 增加serialVersionUID
	}

	private static void serialPerson() {
		Person person = new Person();
		person.setAge(30);
		// 序列化
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.ser"));
			oos.writeObject(person);
			oos.close();
			System.out.println("serialize  sucess");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 反序列化
	private static Person deserialPerson() {
		Person per = null;
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.ser"));
			per = (Person) ois.readObject();
			ois.close();
			System.out.println("Deserialze sucess");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return per;
	}
}
