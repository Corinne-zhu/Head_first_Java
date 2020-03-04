package Chapter2_classAndObject;

/* user 進行猜字 */
public class Player {
	int number= 0;  // 要被猜的數字

	public void guess() {
		this.number = (int)(Math.random() * 10) ;
		System.out.println("I'm guessing " + this.number);
	}

}
