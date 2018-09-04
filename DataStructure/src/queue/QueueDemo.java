package queue;

public class QueueDemo {
	public static void main(String args[]) throws Exception {
		String[] strArr = new String[10];
		Q_using_Array<String> stringQ = new Q_using_Array<>(strArr);
		stringQ.enqueue("a");
		stringQ.enqueue("b");
		stringQ.enqueue("c");
		stringQ.enqueue("d");
		stringQ.enqueue("e");
		stringQ.enqueue("f");
		stringQ.printQueue();

		stringQ.dequeue();
		stringQ.printQueue();
		stringQ.dequeue();
		stringQ.printQueue();
		stringQ.dequeue();
		stringQ.printQueue();
		Integer [] arr = new Integer[10];
		Q_using_Array<Integer> intQ = new Q_using_Array<>(arr);
		for (int i = 0; i < 10; i++) {
			intQ.enqueue(i);
		}
		intQ.printQueue();

		intQ.dequeue();
		intQ.printQueue();

		intQ.dequeue();
		intQ.printQueue();

		intQ.dequeue();
		intQ.printQueue();

		intQ.dequeue();
		intQ.printQueue();

		intQ.dequeue();
		intQ.printQueue();
		
		
		Q_using_LinkedList<String> stringQue = new Q_using_LinkedList<>();
		stringQue.enqueue("a");
		stringQue.enqueue("b");
		stringQue.enqueue("c");
		stringQue.enqueue("d");
		stringQue.enqueue("e");
		stringQue.enqueue("f");
		stringQue.printQueue();

		stringQue.dequeue();
		stringQue.printQueue();
		stringQue.dequeue();
		stringQue.printQueue();
		stringQue.dequeue();
		stringQue.printQueue();
		Q_using_LinkedList<Integer> intQue = new Q_using_LinkedList<>();
		for (int i = 0; i < 10; i++) {
			intQue.enqueue(i);
		}
		intQue.printQueue();

		intQue.dequeue();
		intQue.printQueue();

		intQue.dequeue();
		intQue.printQueue();

		intQue.dequeue();
		intQue.printQueue();

		intQue.dequeue();
		intQue.printQueue();

		intQue.dequeue();
		intQue.printQueue();
	}

}
