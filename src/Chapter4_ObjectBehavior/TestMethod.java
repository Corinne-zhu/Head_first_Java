package Chapter4_ObjectBehavior;

public class TestMethod {

	public static void main(String[] args) {
		TestMethod t = new TestMethod();
		short c = 7; // short 隱式轉換為int
		int value = t.calcArea(c, 15);
		System.out.println(value);
	}

	public int calcArea(int height, int width) {
		return height * width;
	}

}
