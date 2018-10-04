package multithreading;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

	private BlockingQueue<Message> queue;

	public Producer(BlockingQueue<Message> queue2) {
		this.queue = queue2;
	}

	public BlockingQueue<Message> getQueue() {
		return queue;
	}

	public void setQueue(BlockingQueue<Message> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			Message msg = new Message(" " + i);
			try {
				Thread.sleep(i);
				queue.put(msg);
				System.out.println("produced " + msg.getMsg());
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
		Message msg = new Message("exit");
		try {
			queue.put(msg);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}

	}

}
