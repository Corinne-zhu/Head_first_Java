package Chapter1_basic_conception;

/*
 * 循環
 * */

public class WhileLoop {

	public static void main(String[] args) {
		countBottles();

	}

	// 從 5 倒數到0
	public static void countBottles() {
		int beerNum = 5;
		String word = "bottles";

		while (beerNum > 0) {
			if (beerNum == 1) {
				word = "bottle";
			}

			System.out.println(beerNum + " " + word + " of beer on the wall");
			System.out.println("Take one down.");
			System.out.println("Pass it around.");

			beerNum = beerNum - 1;

			if (beerNum == 0) {
				System.out.println("No more bottles of beer on the wall");
			}
		}
	}
}
