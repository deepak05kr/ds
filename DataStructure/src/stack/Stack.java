package stack;

public interface Stack<T> {
	public T push(T data);

	public T pop();
	
	public boolean isEmpty();
	
	public boolean isFull();

}
