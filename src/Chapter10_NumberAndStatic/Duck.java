package Chapter10_NumberAndStatic;

public class Duck {

	private int size;
	private static int duckCount= 0;

	public Duck(){
		duckCount++;
	}

	public int getSize() {
		return this.size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getDuckCount() {
		return duckCount;
	}
}


