package multithreading;

public class MyRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println("Thread started : " + Thread.currentThread().getName());
		try {
			Thread.sleep(4000);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		System.out.println("Thread ended : " + Thread.currentThread().getName());
	}

}
