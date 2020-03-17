package Chapter9_ConstructorAndGC;

public class Hippo extends Animal {

	public Hippo() {
		super();
	}

	public Hippo(String name) {
		super(name); // 對應到Animal有參的構造函數
	}
}
