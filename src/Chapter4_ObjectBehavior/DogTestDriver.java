package Chapter4_ObjectBehavior;

import Chapter3_VariableType.Dog;

public class DogTestDriver {

	public static void main(String[] args) {
		Dog one = new Dog();
		one.size = 70 ;

		Dog two = new Dog();
		two.size = 8 ;

		Dog three  =  new Dog();
		three.size = 35 ;

		// 大小影響叫聲
		one.bark();
		two.bark();
		three.bark();

	}

}
