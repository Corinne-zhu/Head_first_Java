package Chapter14_SerializeAndFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Test {

	public static void main(String[] args) {
		 try {
			FileOutputStream fos = new FileOutputStream(new File("Foo.ser"));
			ObjectOutputStream  oos  = new ObjectOutputStream(fos);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
