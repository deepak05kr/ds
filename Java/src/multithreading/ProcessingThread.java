package multithreading;

import java.util.concurrent.atomic.AtomicInteger;

public class ProcessingThread implements Runnable {

	private AtomicInteger count = new AtomicInteger();

	@Override
	public void run() {
		for (int i = 1; i < 5; i++) {
			processSomething(i);
			count.incrementAndGet();
		}
	}

	private void processSomething(int i) {
		try {
			Thread.sleep(i * 1000);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}

	public int getCount() {
		return this.count.get();
	}

}
