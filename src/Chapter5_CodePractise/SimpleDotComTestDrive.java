package Chapter5_CodePractise;

// 測試猜地址遊戲
public class SimpleDotComTestDrive {

	public static void main(String[] args) {
		int numOfGuesses = 0; // 記錄玩家猜測的次數
		GameHelper helper = new GameHelper();

		SimpleDotCom dot = new SimpleDotCom();
		int randomNum = (int) (Math.random() * 5); // 隨機產生第一格的位置

		int[] locations = { randomNum, randomNum + 1, randomNum + 2 }; // 產生目標位置：三個連續的空間
		dot.setLocationCells(locations);

		StringBuilder sb = new StringBuilder();
		sb.append("the target number is : ");

		// show 出目標數字
		for (int i : locations) {
			sb.append(i).append("  ");
		}
		System.out.println(sb.toString());

		boolean isAlive = true;
		while (isAlive == true) {
			String guess = helper.getUserInput("enter a number :");
			String result = dot.checkYourself(guess);
			numOfGuesses++;
			if ("kill".equals(result)) {
				isAlive = false;
				System.out.println("You took " + numOfGuesses + " guesses!");
			}

		}

	}
}
