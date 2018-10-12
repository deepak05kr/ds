package stack;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class StackTest {
	@Test
	public void StringPustTest_LinkedListStack() {
		Stack_Using_LinkedList<String> stringStack = new Stack_Using_LinkedList<>();
		stringStack.push("e");
		assertTrue("e".equals(stringStack.getTop().getData()));
		stringStack.push("d");
		assertTrue("d".equals(stringStack.getTop().getData()));
		stringStack.push("c");
		assertTrue("c".equals(stringStack.getTop().getData()));
		stringStack.push("b");
		assertTrue("b".equals(stringStack.getTop().getData()));
		stringStack.push("a");
		assertTrue("a".equals(stringStack.getTop().getData()));
	}

	@Test
	public void StringPopTest_LinkedListStack() {
		Stack_Using_LinkedList<String> stringStack = new Stack_Using_LinkedList<>();
		stringStack.push("e");
		stringStack.push("d");
		stringStack.push("c");
		stringStack.push("b");
		stringStack.push("a");

		assertTrue("a".equals(stringStack.pop()));
		assertTrue("b".equals(stringStack.pop()));
		assertTrue("c".equals(stringStack.pop()));
		assertTrue("d".equals(stringStack.pop()));
		assertTrue("e".equals(stringStack.pop()));
	}

	@Test
	public void IntegerPustTest_LinkedListStack() {
		Stack_Using_LinkedList<Integer> intStack = new Stack_Using_LinkedList<>();
		intStack.push(1);
		assertTrue(intStack.getTop().getData() == 1);
		intStack.push(2);
		assertTrue(intStack.getTop().getData() == 2);
	}

	@Test
	public void IntegerPopTest_LinkedListStack() {
		Stack_Using_LinkedList<Integer> intStack = new Stack_Using_LinkedList<>();
		intStack.push(1);
		intStack.push(2);
		intStack.push(3);
		intStack.push(4);
		intStack.push(5);

		assertTrue(intStack.pop() == 5);
		assertTrue(intStack.pop() == 4);
	}
}