package Chapter14_SerializeAndFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//序列化和反序列化
public class GameServerTest {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		GameCharacter one = new GameCharacter(50, "Elf", new String[] { "bow", "sword", "dust" });
		GameCharacter two = new GameCharacter(200, "Troll", new String[] { "bare hands", "big ax" });
		GameCharacter three = new GameCharacter(120, "Magician", new String[] { "spells", "invisibility" });

		// 序列化
		ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("Game.ser"));
		os.writeObject(one);
		os.writeObject(two);
		os.writeObject(three);
		os.close();

		// 先把三個對象設置為null 引用，反序列化觀察結果
		one = null;
		two = null;
		three = null;

		// 反序列化
		ObjectInputStream is = new ObjectInputStream(new FileInputStream("Game.ser"));
		one = (GameCharacter) is.readObject();
		two = (GameCharacter) is.readObject();
		three = (GameCharacter) is.readObject();
		is.close();

		System.out.println(" one object : " + one);
		System.out.println(" two object : " + two);
		System.out.println(" three object : " + three);

	}

}

//定義一個被序列化的對象
class GameCharacter implements Serializable {
	int power;
	String type;
	String[] weapons;

	public GameCharacter(int power, String type, String[] weapons) {
		super();
		this.power = power;
		this.type = type;
		this.weapons = weapons;
	}

	public int getPower() {
		return this.power;
	}

	public String getType() {
		return this.type;
	}

	public String getWeapons() {
		String weaponList = "";

		for (int i = 0; i < this.weapons.length; i++) {
			weaponList += this.weapons[i] + " ";
		}

		return weaponList;
	}

	@Override
	public String toString() {
		String str;
		str = "power  is: " + this.getPower() + " , type is: " + this.getType() + " , weapons are : "
				+ this.getWeapons();
		return str;
	}

}
