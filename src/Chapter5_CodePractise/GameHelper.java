package Chapter5_CodePractise;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 人機交互的功能， user 從鍵盤錄入要猜的地址
class GameHelper {
	public String getUserInput(String prompt) {
		String inputLine = null;
		System.out.print(prompt + " ");
		try {
			BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
			inputLine = is.readLine();

			if (inputLine.length() == 0) {
				return null;
			}
		} catch (Exception e) {
			System.out.println("IOException : " + e);
		}
		return inputLine;
	}
}
