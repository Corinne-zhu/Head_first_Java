package Chapter15_NetworkAndThread;

public class ConcurrencyDemo implements Runnable {
	private int balance;

	public static void main(String[] args) {
		ConcurrencyDemo test = new ConcurrencyDemo();

		Thread oneThread = new Thread(test);
		Thread twoThread = new Thread(test);

		oneThread.setName("one");
		twoThread.setName("two");
		oneThread.start();
		twoThread.start();
	}

	@Override
	public void run() {
		for (int i = 0; i < 15; i++) {
			this.increment();
			System.out.println(Thread.currentThread().getName() + " balance is : " + this.balance);
		}
	}

	// 遞增
	public synchronized void increment() {
		int i = this.balance;
		this.balance = i + 1;
	}
}
