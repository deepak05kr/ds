package stack;

public class Stack_using_Array<T> implements Stack {

	int top, capacity;
	private T[] arr;

	public Stack_using_Array(T[] arr) {
		super();
		this.arr = arr;
		this.top = -1;
		this.capacity = 10;

	}

	public int getTop() {
		return top;
	}

	public void setTop(int top) {
		this.top = top;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public T[] getArr() {
		return arr;
	}

	public void setArr(T[] arr) {
		this.arr = arr;
	}

	@Override
	public Object push(Object data) {
		if (isFull()) {
			throw new StackOverflowError();
		} else {
			this.top++;
			arr[this.top] = (T) data;
			return arr[this.top];
		}

	}

	@Override
	public Object pop() {
		if (isEmpty()) {
			return null;
		} else {
			T t = arr[this.top];
			arr[this.top] = null;
			this.top--;
			return t;
		}
	}

	@Override
	public boolean isEmpty() {
		return (this.top == -1);
	}

	@Override
	public boolean isFull() {
		return (this.top == capacity - 1);
	}

}
