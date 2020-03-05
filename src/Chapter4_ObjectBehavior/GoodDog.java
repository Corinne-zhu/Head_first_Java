package Chapter4_ObjectBehavior;

// 封裝
public class GoodDog {
	private int size; // 將實例變量設為private

	// 設置getter ， setter
	public int getSize() {
		return this.size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void bark() {
		if (this.size > 60) {
			System.out.println("Woof!  Woof!");
		} else if (this.size > 14) {
			System.out.println("Ruff !  Ruff !");
		} else {
			System.out.println("Yip !  Yip!");
		}
	}
}
