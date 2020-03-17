package Chapter9_ConstructorAndGC;

// 驗證子類的構造方法
public class SonOfBoo extends Boo {

	public SonOfBoo() {
		super("Boo");
	}

	public SonOfBoo(int i) {
		super("Fred");
	}

	public SonOfBoo(String s) {
		super(42);
	}

}
