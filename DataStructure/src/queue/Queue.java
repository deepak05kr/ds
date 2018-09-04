package queue;

import linkedList.ListNode;

public class Queue<T> {
	private ListNode<T> front = null;
	private ListNode<T> rear = null;

	public ListNode<T> getFront() {
		return front;
	}

	public void setFront(ListNode<T> front) {
		this.front = front;
	}

	public ListNode<T> getRear() {
		return rear;
	}
	public T getRearData() {
		return rear.getData();
	}
	public void setRear(ListNode<T> rear) {
		this.rear = rear;
	}

	public Queue(ListNode<T> front, ListNode<T> rear) {
		super();
		this.front = front;
		this.rear = rear;
	}

	public Queue() {
		super();
	}

	public T enqueue(T data) {
		if (getRear() == null) {
			setRear(new ListNode<>(data));
			setFront(getRear());
			return getRear().getData();
		} else {
			ListNode<T> newNode = new ListNode<T>(data);
			getRear().setNext(newNode);
			setRear(newNode);
			return getRear().getData();
		}
	}

	public T dequeue() throws Exception {
		ListNode<T> rear = (linkedList.ListNode<T>) getRear();
		ListNode<T> front = (linkedList.ListNode<T>) getFront();
		if(front==null) {
//			throw new Exception("queue is empty");
			return null;
		}
		ListNode<T> deletedNode = front;
		if (rear.equals(front)) {
			setRear(null);
			setFront(null);
		} else {
			setFront(front.getNext());
		}
		return deletedNode.getData();
	}

	public void printQueue() {
		if (getFront() != null) {
			ListNode<T> currNode = getFront();
			while (currNode != null) {
				System.out.print(currNode.getData()+" => ");
				currNode = currNode.getNext();
			}
			System.out.println(currNode);
		}
	}

	public boolean isEmpty() {
		return getFront()==null;
	}
}
