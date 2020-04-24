package Chapter15_NetworkAndThread;

// 進程演示
public class ThreadDemo {

	public static void main(String[] args) throws InterruptedException {
		setupThread();

		//另個一種新增Thread 的方法
		Thread anotherThread =  new ThreadDemo().new ThreadChild();
		anotherThread.sleep(2000); // 停頓2S
		anotherThread.start();
	}

	// 如何啟動一個新的線程
	public static void setupThread() {
		Thread myThread = new Thread(new ThreadDemo().new MyRunnable());

		// 調用start() 才會讓線程開始執行。在此之前，它只是一個Thread 實例， 並不是真正的線程
		myThread.start();

		//
		System.out.println("back in main");
	}


	// 實現Runnable 接口
	public class MyRunnable implements Runnable {

		@Override
		public void run() {
			this.go();
		}

		public void go() {
			this.doMore();
		}

		public void doMore() {
			System.out.println("top of the stack");
		}
	}


	//創建一個Thread 的子類， 因為Thread 實現了Runnable接口
	public class ThreadChild  extends Thread{

		@Override
		public void run() {

			super.run();
			System.out.println("I am also in the Thread!");
		}

	}

}
