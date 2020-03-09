package Chapter5_CodePractise;

import java.util.ArrayList;

// 測試猜地址遊戲
public class SimpleDotComTestDrive {

	public static void main(String[] args) {
		int numOfGuesses = 0; // 記錄玩家猜測的次數
		GameHelper helper = new GameHelper();

		SimpleDotCom dot = new SimpleDotCom();
		int randomNum = (int) (Math.random() * 5); // 隨機產生第一格的位置

		ArrayList<String> locations = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			locations.add(String.valueOf(randomNum + i));
		}

		dot.setLocationCells(locations); // 將list 回傳到待猜測的列表中

		StringBuilder sb = new StringBuilder();
		sb.append("the target number is : ");

		// show 出目標數字
		for (String str : locations) {
			sb.append(str).append("  ");
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
