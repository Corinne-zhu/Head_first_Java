package Chapter9_ConstructorAndGC;

import java.util.ArrayList;

public class TestLifeSupportSim {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		V2Radiator v2 = new V2Radiator(list);  // 5 個對象
		System.out.println("------------------------------------");
		V3Radiator v3 = new V3Radiator(list); // (上圖V2 的5個對象)  + ( V3 繼承V2 而來的5個對象) + ( V3 自己的10個對象)
	}
}

class V2Radiator {
	public V2Radiator(ArrayList list) {
		for (int x = 0; x < 5; x++) {
			list.add(new SimUnit("V2Radiator"));
		}
		System.out.println(list);
	}
}

class V3Radiator extends V2Radiator {
	public V3Radiator(ArrayList list) {
		super(list);
		for (int x = 0; x < 10; x++) {
			list.add(new SimUnit("V3Radiator"));
		}

		System.out.println(list);
	}
}

class RetentionBot {
	public RetentionBot(ArrayList list) {
		list.add(new SimUnit("Retention"));
	}
}

class SimUnit {
	String botType;

	SimUnit(String type) {
		this.botType = type;
	}

	int powerUse() {
		if ("Retention".equals(this.botType)) {
			return 2;

		} else {
			return 4;
		}
	}
}
