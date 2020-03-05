package Chapter4_ObjectBehavior;

//  測試封裝後的GoodDog類

public class GoodDogTestDriver {

	public static void main(String[] args) {
		GoodDog one = new GoodDog();
		one.setSize(70);

		System.out.println("The size of dog one is : " + one.getSize());
		one.bark();
	}
}
