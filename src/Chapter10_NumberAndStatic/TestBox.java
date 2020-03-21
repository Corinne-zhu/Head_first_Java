package Chapter10_NumberAndStatic;

//測試 autoboxing

public class TestBox {
	Integer i;
	int j;

	public static void main(String[] args) {
		TestBox t = new TestBox();
		t.go();
	}

	public void go() {
		this.j = this.i;
		System.err.println(this.j);
		System.out.println(this.i);
	}

}
