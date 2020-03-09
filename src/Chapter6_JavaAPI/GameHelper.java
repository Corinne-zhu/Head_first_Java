package Chapter6_JavaAPI;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GameHelper {
	private static final String alphabet = "abcdefg";
	private int gridLength = 7;
	private int gridSize = 49;
	private int[] grid = new int[this.gridSize]; // 7*7 的方格
	private int comCount = 0;

	// 獲取user 在鍵盤上輸入的區域
	public String getUserInput(String prompt) {
		String inputLine = null;
		System.out.println(prompt + "  ");

		try {
			BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
			inputLine = is.readLine();
			if (inputLine.length() == 0) {
				return null;
			}
		} catch (Exception e) {
			System.out.println("讀取位置失敗！！");
		}
		return inputLine.toLowerCase();
	}

	// 設置DotCom的位置： 隨機產生一段連續的單元格空間
	public ArrayList<String> placeDotCom(int comSize) {
		ArrayList<String> alphaCells = new ArrayList<String>();
		String temp = null;
		int[] coords = new int[comSize]; // 坐標
		int attempts = 0;
		boolean success = false;
		int location = 0;

		this.comCount++;
		int incr = 1;

		if ((this.comCount % 2) == 1) {
			incr = this.gridLength;
		}

		while (!success & attempts++ < 200) {
			location = (int) (Math.random() * this.gridSize);
			int x = 0;
			success = true;
			while (success && x < comSize) {
				if (this.grid[location] == 0) { // 判斷X坐標是否使用
					coords[x++] = location;
					location += incr; // 嘗試下一個節點
					if (location >= this.gridSize) { // 超出下邊界
						success = false;
					}

					if (x > 0 && (location % this.gridLength == 0)) { // 超出有邊界
						success = false;
					}
				} else {
					System.out.println("location is : " + location);
					success = false;
				}
			}
		}

		int x = 0;
		int row = 0;
		int column = 0;
		while (x < comSize) {
			this.grid[coords[x]] = 1; // 標記格子已用
			row = coords[x] / this.gridLength;
			column = coords[x] % this.gridLength;
			temp = String.valueOf(alphabet.charAt(column));

			alphaCells.add(temp.concat(Integer.toString(row)));
			x++;
		}

		return alphaCells;
	}
}
