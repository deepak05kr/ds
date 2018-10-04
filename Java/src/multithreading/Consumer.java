package multithreading;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
	private BlockingQueue<Message> queue;

	public BlockingQueue<Message> getQueue() {
		return queue;
	}

	public void setQueue(BlockingQueue<Message> queue) {
		this.queue = queue;
	}

	public Consumer(BlockingQueue<Message> queue) {
		super();
		this.queue = queue;
	}

	@Override
	public void run() {
		try {
			Message msg;
			while ((msg = queue.take()).getMsg() != "exit") {
				Thread.sleep(10);
				System.out.println("consumed " + msg.getMsg());
			}
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}

}
