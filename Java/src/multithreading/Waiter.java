package multithreading;

public class Waiter implements Runnable {

	Message msg;

	public Message getMsg() {
		return msg;
	}

	public void setMsg(Message msg) {
		this.msg = msg;
	}

	public Waiter(Message msg) {
		super();
		this.msg = msg;
	}

	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		synchronized (msg) {
			try {
				System.out.println(name + " waiting to get notified at time : " + System.currentTimeMillis());
				msg.wait();
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
			System.out.println(name + " waiter thread got notified as time : " + System.currentTimeMillis());
			System.out.println(name + " processed : " + msg.getMsg());

		}

	}

}
