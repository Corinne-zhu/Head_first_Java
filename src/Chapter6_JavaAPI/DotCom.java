package Chapter6_JavaAPI;

import java.util.ArrayList;

public class DotCom {
	private ArrayList<String> locationCells; // DotCom的位置， 因為一個Dotcom佔三個單元格
	private String name; // 每個DotCom 的名稱

	public void setLocationCells(ArrayList<String> locationCells) {
		this.locationCells = locationCells;
	}

	public String getDotComName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// 判斷是否擊中？
	public String checkYourself(String userInput) {
		String result = "miss";
		int index = this.locationCells.indexOf(userInput);
		if (index >= 0) {
			this.locationCells.remove(index);

			if (this.locationCells.isEmpty()) {
				result = "kill";
				System.out.println("you sunk the DotCom , the name is : " + this.name);
			} else {
				result = "hit";
			}
		}

		return result;

	}

}
