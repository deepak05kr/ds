package multithreading;

public class SyncObject implements Runnable {

	Object obj1;
	Object obj2;

	public SyncObject(Object obj1, Object obj2) {
		this.obj1 = obj1;
		this.obj2 = obj2;
	}

	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		System.out.println(name + " aquiring lock on object " + obj1);
		synchronized (obj1) {
			System.out.println(name + " aquired lock on object " + obj1);
			work();

		}
		System.out.println(name + " release lock on object " + obj1);

		System.out.println(name + " aquiring lock on object " + obj2);
		synchronized (obj2) {
			System.out.println(name + " aquired lock on object " + obj2);
			work();

		}
		System.out.println(name + " release lock on object " + obj2);

	}

	private void work() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
