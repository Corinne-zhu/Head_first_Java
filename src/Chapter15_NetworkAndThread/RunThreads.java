package Chapter15_NetworkAndThread;

public class RunThreads implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 25; i++) {
			String name = Thread.currentThread().getName();
			System.out.println(name + " is running");
		}
	}

	public static void main(String[] args) {
		Thread oneThread = new Thread(new RunThreads());
		Thread twoThread = new Thread(new RunThreads());
		oneThread.setName("One");
		twoThread.setName("Two");
		oneThread.start();
		try {
			twoThread.sleep(2000);    //第二個Thread 暫停2S再執行
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		twoThread.start();
	}
}
