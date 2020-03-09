package Chapter5_CodePractise;

import java.util.ArrayList;

// 猜地址的遊戲的實現過程
public class SimpleDotCom {
	private ArrayList<String> locationCells = new ArrayList<String>();
	int numsOfHits; // 猜中的個數

	public void setLocationCells(ArrayList<String> locationCells) {
		this.locationCells = locationCells;
	}

	// 判斷user 猜的是否正確? 返回字符串
	public String checkYourself(String stringGuess) {
		String result = "miss";
		int index = this.locationCells.indexOf(stringGuess); // 判斷當前猜的數字是否存在？
		if (index >= 0) {
			this.locationCells.remove(index); // 猜中則刪除元素，直到list為空程序終止
			if (this.locationCells.isEmpty()) {
				result = "kill";
			} else {
				result = "hit";
			}
		}

		System.out.println(result);
		return result;
	}
}
