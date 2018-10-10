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
	
}