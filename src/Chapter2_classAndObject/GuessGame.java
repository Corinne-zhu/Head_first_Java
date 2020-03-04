package Chapter2_classAndObject;

/* 隨機產生數字 */
public class GuessGame {
	Player p1;
	Player p2;
	Player p3;

	public void startGame() {
		this.p1 = new Player();
		this.p2= new Player();
		this.p3= new Player();

		// 聲明三個變量： 查看是否猜中
		int guessp1 =0;
		int guessp2 =0;
		int guessp3 =0;

		boolean p1isRight= false;
		boolean p2isRight= false;
		boolean p3isRight= false;

		int targetNumber = (int)(Math.random() * 10);  // 產生謎底數字

		System.out.println("I'm thinking of a number beteen 0 and 9 ...");

		while (true) {
			// show 出需要被猜的數字
			System.out.println("Number to guess is : " + targetNumber) ;

			this.p1.guess(); // 選手1開始隨機猜數字
			this.p2.guess();
			this.p3.guess();

			guessp1 = this.p1.number;
			System.out.println("Player one guessed is : "  + guessp1);

			guessp2 = this.p2.number;
			System.out.println("Player two  guessed is : "  + guessp2);

			guessp3= this.p3.number;
			System.out.println("Player three guessed is : " + guessp3);


			//判斷是否猜中？
			if (guessp1==targetNumber) {
				p1isRight = true;
			}

			if (guessp2==targetNumber) {
				p2isRight = true;
			}

			if (guessp3==targetNumber) {
				p3isRight = true;
			}

			//其中一位選手猜中數字，循環結束
			if (p1isRight || p2isRight || p3isRight) {
				System.out.println("We hava a winner!!");
				System.out.println("Player one got it right ? " + p1isRight);
				System.out.println("Player two got it right ? " + p2isRight);
				System.out.println("Player three got it right ? " + p3isRight);
				System.out.println("Game is over!!");
				break;
			} else {
				System.out.println("--------------------------------------------");
				System.out.println("Try it again!");
			}
		}
	}
}
