package queue;

public class QueueDemo {
	public static void main(String args[]) {
		Queue<String> stringQ = new Queue<>();
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
		
		Queue<Integer> intQ = new Queue<>();
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
	}

}
