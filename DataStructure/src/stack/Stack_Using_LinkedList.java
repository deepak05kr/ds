package stack;

import java.util.NoSuchElementException;

import linkedList.ListNode;

public class Stack_Using_LinkedList<T> implements Stack{
	private ListNode<T> top = null;

	public ListNode<T> getTop() {
		return top;
	}

	public void setTop(ListNode<T> top) {
		this.top = top;
	}

	public Stack_Using_LinkedList(ListNode<T> top) {
		super();
		this.top = top;
	}
	public Stack_Using_LinkedList() {
		super();
	}
	@Override
	public ListNode<T> push(Object data) {
		if (getTop() == null) {
			setTop(new ListNode<>((T)data));
		} else {
			ListNode<T> newNode = new ListNode<>((T)data);
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

	@Override
	public boolean isEmpty() {
		// 
		return false;
	}

	@Override
	public boolean isFull() {
		// not applicable for stack implemented using linked list
		return false;
	}

}
