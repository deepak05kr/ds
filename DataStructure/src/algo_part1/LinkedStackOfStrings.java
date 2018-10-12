package algo_part1;

public class LinkedStackOfStrings<Item> {
	private Node first = null;

	private class Node {
		Item item;
		Node next;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public void push(Item item) {
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
	}

	public Item pop() {
		Item item = first.item;
		first = first.next;
		return item;
	}

	public static void main(String args[]) {
		LinkedStackOfStrings stack = new LinkedStackOfStrings<>();
		stack.push("Deepak");
		stack.push("Kumar");
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}
}
