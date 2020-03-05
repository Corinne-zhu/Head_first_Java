package Chapter4_ObjectBehavior;

// 熟悉參數與返回類型
public class ElectricGuitar {
	String brand;
	int numOfPickups;
	boolean rockStarUsesIt;

	public String getBrand() {
		return this.brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getNumOfPickups() {
		return this.numOfPickups;
	}

	public void setNumOfPickups(int numOfPickups) {
		this.numOfPickups = numOfPickups;
	}

	public boolean isRockStarUsesIt() {
		return this.rockStarUsesIt;
	}

	public void setRockStarUsesIt(boolean rockStarUsesIt) {
		this.rockStarUsesIt = rockStarUsesIt;
	}

}
