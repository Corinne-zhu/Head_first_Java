package Chapter6_JavaAPI;

import java.util.ArrayList;

public class DotComBust {
	private GameHelper helper = new GameHelper();
	private ArrayList<DotCom> dotComsList = new ArrayList<DotCom>();
	private int numOfGuesses = 0;

	// 初始化遊戲參數
	private void setUpGame() {
		// 步驟一： 創建三個DotCom並命名
		DotCom one = new DotCom();
		one.setName("Dotcom one");

		DotCom two = new DotCom();
		two.setName("Dotcom two");

		DotCom three = new DotCom();
		three.setName("Dotcom three");

		this.dotComsList.add(one);
		this.dotComsList.add(two);
		this.dotComsList.add(three);

		// 步驟二： 為三個DotCom 設置區域
		for (DotCom dotComToSet : this.dotComsList) {
			ArrayList<String> newLocation = this.helper.placeDotCom(3);
			dotComToSet.setLocationCells(newLocation);
			StringBuilder sb = new StringBuilder();
			sb.append(dotComToSet.getDotComName()).append(" area is :  ").append(newLocation);
			System.out.println(sb);
		}
	}

	// 猜中一個DotCom， 移除一個
	private void checkUserGuess(String userInput) {
		this.numOfGuesses++;
		String result = "miss"; // 先假設沒有猜中
		// 循環檢查每個DotCom ， 確定是否被擊中?
		for (DotCom dots : this.dotComsList) {
			result = dots.checkYourself(userInput);
			if (result.equals("hit")) {
				break;
			}

			if (result.equals("kill")) {
				this.dotComsList.remove(dots); // 猜對一個DotCom的位置則移除
				break;
			}
		}
		System.out.println(result);
	}

	//結束程式
	private void finishGame() {
		System.out.println("All Dot coms are dead!");
		System.out.println("it took you " + this.numOfGuesses + " guesses!");
	}

	//用戶輸入程式
	private void startPlaying() {
		while (!this.dotComsList.isEmpty()) {
			String userGuess = this.helper.getUserInput("Enter a guess");
			this.checkUserGuess(userGuess);
		}
		this.finishGame();
	}

	public static void main(String[] args) {
		DotComBust game = new DotComBust();
		game.setUpGame();
		game.startPlaying();
	}
}
