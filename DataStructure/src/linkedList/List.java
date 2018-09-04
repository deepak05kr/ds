package linkedList;

public class List<T> {

	private ListNode<T> head = null;

	public ListNode<T> getHead() {
		return head;
	}

	public void setHead(ListNode<T> head) {
		this.head = head;
	}

	public List(ListNode<T> head) {
		super();
		this.head = head;
	}

	public List() {
		super();
	}

	public static void main(String args[]) {

		ListNode<String> stringNode = new ListNode<>();
		stringNode.setData("b");
		stringNode.setNext(null);

		ListNode<String> stringNode2 = new ListNode<>();
		stringNode2.setData("a");
		stringNode2.setNext(stringNode);

		stringNode2.printNode();
		stringNode.printNode();

	}

	public ListNode<T> add(T data) {
		if (this.head != null) {
			ListNode<T> currNode = getHead();
			while (currNode.getNext() != null) {
				currNode = currNode.getNext();
			}
			currNode.setNext(new ListNode<>(data));
			return getHead();
		} else {
			this.head = new ListNode<>(data);
			return getHead();
		}
	}

	public void printList() {
		ListNode<T> currNode = getHead();
		while (currNode != null) {
			System.out.print("[ " + currNode.getData() + " ] => ");
			currNode = currNode.getNext();
		}
		System.out.println(currNode);
	}
}
