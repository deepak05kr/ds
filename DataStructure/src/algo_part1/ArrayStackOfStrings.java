package algo_part1;

public class ArrayStackOfStrings<Item> {
	private Item[] s;
	private int N;

	public ArrayStackOfStrings(int capacity) {
		s = (Item[]) new Object[capacity];
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public void push(Item item) {
		if (s.length == N) {
			resize(2 * s.length);
		}
		s[N++] = item;
	}

	private void resize(int size) {
		Item[] copy = (Item[]) new Object[size];
		for (int i = 0; i < N; i++) {
			copy[i] = s[i];
		}
		s = copy;
	}

	public Item pop() {
		Item item = s[--N];
		s[N] = null;
		return item;
	}

	public static void main(String args[]) {
		ArrayStackOfStrings<String> stack = new ArrayStackOfStrings<>(10);
		stack.push("Deepak");
		stack.push("Kumar");
		stack.push("Deepak");
		stack.push("Kumar");
		stack.push("Deepak");
		stack.push("Kumar");
		stack.push("Deepak");
		stack.push("Kumar");
		stack.push("Deepak");
		stack.push("Kumar");
		stack.push("Deepak");
		stack.push("Kumar");
		stack.push("Deepak");
		stack.push("Kumar");
		stack.push("Deepak");
		stack.push("Kumar");
		stack.push("Deepak");
		stack.push("Kumar");
		stack.push("Deepak");
		stack.push("Kumar");
		stack.push("Deepak");
		stack.push("Kumar");
		stack.push("Deepak");
		stack.push("Kumar");
		stack.push("Deepak");
		stack.push("Kumar");
		stack.push("Deepak");
		stack.push("Kumar");
		stack.push("Deepak");
		stack.push("Kumar");
		stack.push("Deepak");
		stack.push("Kumar");
		stack.push("Deepak");
		stack.push("Kumar");
		stack.push("Deepak");
		stack.push("Kumar");
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}
}
