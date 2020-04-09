package Chapter14_SerializeAndFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

// 模擬一個序列化對象的例子
public class SerilizeDemo {

	public static void main(String[] args) throws IOException {
		Foo test = new Foo();
		test.setHeight(100);
		test.setWidth(80);

		// 創建文件路徑
		FileOutputStream fos = new FileOutputStream("foo.ser");
		ObjectOutputStream os = new ObjectOutputStream(fos);
		os.writeObject(test);
		os.close();
	}

}

// 類能被序列化的前提是：必須實現Serializable 接口
class Foo implements Serializable {
	int width;
	int height;

	public int getWidth() {
		return this.width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return this.height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

}
