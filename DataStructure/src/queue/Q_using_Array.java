package queue;

public class Q_using_Array<T> implements Queue {
	private int front, rear;
	private int size, capacity;
	private T arr[];

	public Q_using_Array(int size, int capacity) {
		super();
		this.size = size;
		this.capacity = capacity;
	}

	public Q_using_Array(Object object) {
		super();
		this.size = -1;
		this.capacity = 10;
		this.front = -1;
		this.rear = -1;
		this.arr = (T[]) object;
	}

	public int getFront() {
		return front;
	}

	public void setFront(int front) {
		this.front = front;
	}

	public int getRear() {
		return rear;
	}

	public void setRear(int rear) {
		this.rear = rear;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
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
	public void enqueue(Object data) {
		if (isFull()) {
			return;
		}
		if (isEmpty()) {
			this.size++;
			setFront(this.size);
			setRear(this.size);
			arr[size] = (T) data;

		} else {
			if (size == capacity-1) {
				return;
			}
			this.size++;
			setRear(this.size);
			arr[this.size]=(T) data;
		}
	}

	@Override
	public T dequeue() throws Exception {
		if(isEmpty()) {
			return null;
		}
		T deletedData = arr[this.front];
		this.front++;
		return deletedData;
	}

	@Override
	public void printQueue() {
		for (int i = this.front; i <= this.size; i++) {
			System.out.print(this.arr[i] + " ");
		}
		System.out.println();
	}

	@Override
	public boolean isEmpty() {
		return (this.size == -1);
	}

	@Override
	public boolean isFull() {

		return (this.size == this.capacity);
	}

}
