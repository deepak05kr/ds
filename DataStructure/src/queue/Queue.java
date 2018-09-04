package queue;

public interface Queue<T> {
	public void enqueue(T data);

	public T dequeue() throws Exception;

	public void printQueue();

	public boolean isEmpty();
	
	public boolean isFull();
}
