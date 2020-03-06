package Chapter5_CodePractise;

// 猜地址的遊戲的實現過程
public class SimpleDotCom {
	private int[] locationCells; // 目標區域
	int numsOfHits; // 猜中的個數

	public void setLocationCells(int[] locationCells) {
		this.locationCells = locationCells;
	}


	// 判斷user 猜的是否正確? 返回字符串
	public String checkYourself(String stringGuess) {
		String result = "miss";
		int guess = Integer.parseInt(stringGuess);

		// 比較user 猜中的格子與目標格子比較
		for (int cell : this.locationCells) {
			if (guess == cell) {
				result = "hit";
				this.numsOfHits++;
				break;
			}
		}

		if (this.numsOfHits == this.locationCells.length) {
			result = "kill";
		}

		System.out.println("The result of this term is  " + result);
		return result;
	}
}
