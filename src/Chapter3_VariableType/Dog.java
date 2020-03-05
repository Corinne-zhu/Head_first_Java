package Chapter3_VariableType;

// 創建dog 對象
public class Dog {
	public String name;
	public int size; // 大小影響叫聲

	public Dog() {
		super();
	}

	public Dog(String name, int size) {
		super();
		this.name = name;
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

	public void eat() {
		System.out.println("I like eat meat!");
	}

	public void chaseCat() {
		System.out.println("I can chase cat!");
	}
}
