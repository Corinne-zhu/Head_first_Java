package Chapter10_NumberAndStatic;

public class StaticSupper {
	static {
		System.out.println("super static block");
	}

	public  StaticSupper() {
		System.out.println("super constructor");
	}

}
