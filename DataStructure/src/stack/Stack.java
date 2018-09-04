package stack;

import java.util.NoSuchElementException;

import linkedList.ListNode;

public class Stack<T> {
	private ListNode<T> top = null;

	public ListNode<T> getTop() {
		return top;
	}

	public void setTop(ListNode<T> top) {
		this.top = top;
	}

	public Stack(ListNode<T> top) {
		super();
		this.top = top;
	}
	public Stack() {
		super();
	}
	public ListNode<T> push(T data) {
		if (getTop() == null) {
			setTop(new ListNode<>(data));
		} else {
			ListNode<T> newNode = new ListNode<>(data);
			newNode.setNext(getTop());
			setTop(newNode);

		}
		return this.top;
	}

	public T pop() {
		if (getTop() == null) {
			throw new NoSuchElementException("Under flow exception");
		} else {
			ListNode<T> deletedNode = getTop();
			setTop(getTop().getNext());
			return deletedNode.getData();
					
		}
	}
	public void printStack() {
		if(getTop()==null) {
			System.out.println(getTop());
		}else {
			ListNode<T> currNode = getTop();
			while(currNode!=null) {
				System.out.print(currNode.getData()+" ");
				currNode = currNode.getNext();
			}
					
		}
		System.out.println();
	}
}
