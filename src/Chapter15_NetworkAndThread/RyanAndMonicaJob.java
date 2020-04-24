package Chapter15_NetworkAndThread;

// 演示： 兩個人公用一個帳號， 模擬兩個人取錢的case
public class RyanAndMonicaJob implements Runnable {
	private BankAccount account = new BankAccount();

	public static void main(String[] args) {
		// 建立兩個用戶代表兩個取錢的Thread
		RyanAndMonicaJob job = new RyanAndMonicaJob();

		// 兩個用戶公用一個Accout
		Thread ryan = new Thread(job);
		Thread monica = new Thread(job);

		ryan.setName("Ryan");
		monica.setName("Monica");
		ryan.start();
		monica.start();
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			this.makeWithdraw(10);
			if (this.account.getBalance() < 0) {
				System.out.println("Overdrawn");
			}
		}
	}

	// 取錢的動作(使用synchronized： 每次只能被單一的線程存取 )
	private synchronized void makeWithdraw(int amount) {
		if (this.account.getBalance() >= amount) {
			System.out.println(Thread.currentThread().getName() + " is about to withdraw.");
			System.out.println(Thread.currentThread().getName() + " is going to sleep. ");
			// sleep
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			// woke up
			System.out.println(Thread.currentThread().getName() + " is woke up .");

			// withdraw
			this.account.withdraw(amount);

			// message
			System.out.println(Thread.currentThread().getName() + " completely withdraw : " + amount + "\n"
					+ " There are " + this.account.getBalance() + " left .");

		} else {
			System.out.println("Sorry , not enough money for " + Thread.currentThread().getName());
		}

	}

}

// 銀行帳號
class BankAccount {
	private int balance = 100;

	public int getBalance() {
		return this.balance;
	}

	public void withdraw(int amount) {
		this.balance = this.balance - amount;
	}

}
