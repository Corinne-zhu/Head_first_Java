package Chapter10_NumberAndStatic;

// 測試靜態方法與靜態變量的存取
public class StaticTest {
	static int count = 0;

	public static void main(String[] args) {
		staticMethod();



	}

	public static void staticMethod() {
		System.out.println("I'm a static method");
//		StaticTest t = new StaticTest();
//		t.nonStaticMethod();  // error : 靜態方法不能存取非靜態的方法

		// 靜態方法可以存取靜態變量嗎？ （可以！）

		count++;
		System.out.println(count);

		count++;
		System.out.println(count);

		count++;
		System.out.println(count);

	}

	public void nonStaticMethod() {
		System.out.println("I'm not a static method");
		staticMethod();
	}

}
