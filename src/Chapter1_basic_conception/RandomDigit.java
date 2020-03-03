package Chapter1_basic_conception;

// 隨機數
public class RandomDigit {

	public static void main(String[] args) {
		randomStr();
	}

	// 從一個數組中隨機抓取出一個數字
	public static void randomStr() {
		String[] pets = { "Cat", "Dog", "Fox", "Zebra", "Tiger", "Lion", "Bear", "Monkey", "Rabbit" };

		int petsCount = pets.length;
		int num = (int) (Math.random() * petsCount);

		System.out.println("You choose : " + pets[num]);
	}

}
