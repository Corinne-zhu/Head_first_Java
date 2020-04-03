package Chapter12_GuiDemo;
// 內部類

public class MyOuter {
	private int x;


	public void doStuff() {
		MyInner inner = new MyInner();
		inner.go();
	}

	// 內部類
	class MyInner {
		void go() {
			MyOuter.this.x = 42;
		}
	}

}
