package Chapter10_NumberAndStatic;

//測試靜態變量是共享的
public class DuckTest {
	public static void main(String[] args) {
		Duck d1 = new Duck();
		System.out.println(d1.getDuckCount());

		Duck d2 = new Duck();
		System.out.println(d2.getDuckCount());

		Duck d3 = new Duck();
		System.out.println(d3.getDuckCount());

		DuckTest t = new DuckTest();

	}

}
