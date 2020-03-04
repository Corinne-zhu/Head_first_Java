package Chapter3_VariableType;

public class DogArrayDriver {

	public static void main(String[] args) {
		generateArray();

	}

	public static void generateArray() {
		Dog[] pets = new Dog[7]; // 聲明一個Dog 類型的數組

		// 創建Dog 對象並賦值給數組
		pets[0] = new Dog();
		pets[1] = new Dog();
		pets[2] = new Dog();
		pets[3] = new Dog();
		pets[4] = new Dog();
		pets[5] = new Dog();
		pets[6] = new Dog();

		// 存取Dog數組中的Dog
		pets[0].name = "Fido";
		pets[0].bark();

		System.out.println("First of the dog's name is : " + pets[0].name);

		//逐個對Dog 執行bark()
		int x=0;
		while(x<pets.length) {
			pets[x].bark();
			x=x+1;
		}
	}
}
