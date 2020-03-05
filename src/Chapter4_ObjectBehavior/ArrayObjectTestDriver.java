package Chapter4_ObjectBehavior;

// 測試數組對象的存取

public class ArrayObjectTestDriver {

	public static void main(String[] args) {
		GoodDog[]  pets = new GoodDog[7];  // 聲明一下連載7個GoodDog引用的數組。

		pets[0] = new GoodDog();  // 創建出GoodDog對象，並放到數組中
		pets[1] = new GoodDog();

		// 調用對象的方法
		pets[0].setSize(100);
		pets[1].setSize(50);

		System.out.println("the size of dog one is : " + pets[0].getSize() );
		System.out.println("the size of dog two is : " + pets[1].getSize() );
	}

}
