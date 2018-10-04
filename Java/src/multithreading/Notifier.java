package multithreading;

public class Notifier implements Runnable {

	private Message msg;

	public Message getMsg() {
		return msg;
	}

	public void setMsg(Message msg) {
		this.msg = msg;
	}

	public Notifier(Message msg) {
		super();
		this.msg = msg;
	}

	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		System.out.println(name + " started");
		try {
			Thread.sleep(1000);
			synchronized (msg) {
				msg.setMsg(name + " notifier work done");
				// msg.notify();
				msg.notifyAll();
			}
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}

}
