package Chapter4_ObjectBehavior;

public class TestMethod {

	public static void main(String[] args) {
		TestMethod t  = new TestMethod();
		long c =7 ;
		int value = t.calcArea(c, 15);
		System.out.println(value);

	}

	public int calcArea  (int height  , int width) {
		return height * width;
	}

}
