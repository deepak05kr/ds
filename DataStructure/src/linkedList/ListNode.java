package linkedList;

public class ListNode<T> {
	private T data;
	private ListNode next;

	public ListNode(T data, ListNode next) {
		super();
		this.data = data;
		this.next = next;
	}
	public ListNode() {
		super();
	}
	public ListNode(T data) {
		super();
		this.data= data;
		this.next = null;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public ListNode getNext() {
		return next;
	}

	public void setNext(ListNode next) {
		this.next = next;
	}
	public void printNode() {
		System.out.print(this.data+" ");
		if(this.next!=null) {
			System.out.println(this.next.getData());
		}else {
			System.out.println(this.next);
		}
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((next == null) ? 0 : next.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ListNode other = (ListNode) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (next == null) {
			if (other.next != null)
				return false;
		} else if (!next.equals(other.next))
			return false;
		return true;
	}
	
}
