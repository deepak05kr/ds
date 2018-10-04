package multithreading;

public class ThreadDeadLock {
	public static void main(String args[]) throws InterruptedException {
		Object obj1 = new Object();
		Object obj2 = new Object();
		Object obj3 = new Object();

		Thread t1 = new Thread(new SyncObject(obj1, obj2));
		Thread t2 = new Thread(new SyncObject(obj2, obj3));
		Thread t3 = new Thread(new SyncObject(obj3, obj1));
		
		t1.start();
		Thread.sleep(5000);
		t2.start();
		Thread.sleep(5000);
		t3.start();
	}
}
