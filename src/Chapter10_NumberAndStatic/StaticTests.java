package Chapter10_NumberAndStatic;

// 測試初始化的順序 : 靜態代碼塊 --> main() 方法   -->   父類構造方法  -->   子類構造方法
public class StaticTests extends StaticSupper {
	static int rand;

	static {
		rand = (int) ((Math.random() * 6) + 1);
		System.out.println("static block "+rand);
	}


	public StaticTests() {
		System.out.println("constructor");
	}




	public static void main(String[] args) {
		System.out.println("in main");
		StaticTests st = new StaticTests();
	}
}
