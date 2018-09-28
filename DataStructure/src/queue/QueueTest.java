package queue;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class QueueTest {

	@Test
	public void StringEnqueueTest_ArrQ() {
		String[] strArr = new String[10];
		Q_using_Array<String> stringQ = new Q_using_Array<>(strArr);

		assertEquals(-1, stringQ.getRear());

		stringQ.enqueue("a");
		assertTrue("a".equals(stringQ.getArr()[stringQ.getRear()]));

		stringQ.enqueue("b");
		assertTrue("b".equals(stringQ.getArr()[stringQ.getRear()]));

		stringQ.enqueue("c");
		assertTrue("c".equals(stringQ.getArr()[stringQ.getRear()]));

		stringQ.enqueue("d");
		assertTrue("d".equals(stringQ.getArr()[stringQ.getRear()]));

		stringQ.enqueue("e");
		assertTrue("e".equals(stringQ.getArr()[stringQ.getRear()]));

		stringQ.enqueue("f");
		assertTrue("f".equals(stringQ.getArr()[stringQ.getRear()]));

		stringQ.enqueue("g");
		assertTrue("g".equals(stringQ.getArr()[stringQ.getRear()]));

		stringQ.enqueue("h");
		assertTrue("h".equals(stringQ.getArr()[stringQ.getRear()]));

		stringQ.enqueue("i");
		assertTrue("i".equals(stringQ.getArr()[stringQ.getRear()]));

		stringQ.enqueue("j");
		assertTrue("j".equals(stringQ.getArr()[stringQ.getRear()]));

		stringQ.enqueue("k");
		assertTrue(!"k".equals(stringQ.getArr()[stringQ.getRear()]));

	}

	@Test
	public void StringDequeueTest_ArrQ() throws Exception {
		String[] strArr = new String[10];
		Q_using_Array<String> stringQ = new Q_using_Array<>(strArr);

		assertEquals(-1, stringQ.getRear());

		stringQ.enqueue("a");
		stringQ.enqueue("b");
		stringQ.enqueue("c");
		stringQ.enqueue("d");
		stringQ.enqueue("e");
		stringQ.enqueue("f");
		stringQ.enqueue("g");
		stringQ.enqueue("h");
		stringQ.enqueue("i");
		stringQ.enqueue("j");

		assertTrue("a".equals(stringQ.dequeue()));
		assertTrue("b".equals(stringQ.dequeue()));
		assertTrue("c".equals(stringQ.dequeue()));
		assertTrue("d".equals(stringQ.dequeue()));
		assertTrue("e".equals(stringQ.dequeue()));
		assertTrue("f".equals(stringQ.dequeue()));
		assertTrue("g".equals(stringQ.dequeue()));
		assertTrue("h".equals(stringQ.dequeue()));
		assertTrue("i".equals(stringQ.dequeue()));
		assertTrue("j".equals(stringQ.dequeue()));

	}

	@Test
	public void intEnqueueTest_ArrQ() {
		Integer[] arr = new Integer[10];
		Q_using_Array<Integer> intQ = new Q_using_Array<>(arr);
		for (int i = 0; i < 10; i++) {
			intQ.enqueue(i);
			assertTrue(i - (intQ.getArr()[intQ.getRear()]) == 0);
		}
	}

	@Test
	public void intDequeueTest_ArrQ() throws Exception {
		Integer[] arr = new Integer[10];
		Q_using_Array<Integer> intQ = new Q_using_Array<>(arr);
		for (int i = 0; i < 10; i++) {
			intQ.enqueue(i);
		}
		for (int i = 0; i < 10; i++) {
			assertTrue(i - intQ.dequeue() == 0);
		}
	}


	@Test
	public void StringEnqueueTest_LinkedListQueue() {
		Q_using_LinkedList<String> stringQ = new Q_using_LinkedList<>();

		stringQ.enqueue("a");
		assertTrue("a".equals(stringQ.getRearData()));

		stringQ.enqueue("b");
		assertTrue("b".equals(stringQ.getRearData()));

		stringQ.enqueue("c");
		assertTrue("c".equals(stringQ.getRearData()));

		stringQ.enqueue("d");
		assertTrue("d".equals(stringQ.getRearData()));

		stringQ.enqueue("e");
		assertTrue("e".equals(stringQ.getRearData()));

		stringQ.enqueue("f");
		assertTrue("f".equals(stringQ.getRearData()));

		stringQ.enqueue("g");
		assertTrue("g".equals(stringQ.getRearData()));

		stringQ.enqueue("h");
		assertTrue("h".equals(stringQ.getRearData()));

		stringQ.enqueue("i");
		assertTrue("i".equals(stringQ.getRearData()));

		stringQ.enqueue("j");
		assertTrue("j".equals(stringQ.getRearData()));

		stringQ.enqueue("k");
		assertTrue("k".equals(stringQ.getRearData()));

	}

	@Test
	public void StringDequeueTest_LinkedListQueue() throws Exception {
		Q_using_LinkedList<String> stringQ = new Q_using_LinkedList<>();

		stringQ.enqueue("a");
		stringQ.enqueue("b");
		stringQ.enqueue("c");
		stringQ.enqueue("d");
		stringQ.enqueue("e");
		stringQ.enqueue("f");
		stringQ.enqueue("g");
		stringQ.enqueue("h");
		stringQ.enqueue("i");
		stringQ.enqueue("j");

		assertTrue("a".equals(stringQ.dequeue()));
		assertTrue("b".equals(stringQ.dequeue()));
		assertTrue("c".equals(stringQ.dequeue()));
		assertTrue("d".equals(stringQ.dequeue()));
		assertTrue("e".equals(stringQ.dequeue()));
		assertTrue("f".equals(stringQ.dequeue()));
		assertTrue("g".equals(stringQ.dequeue()));
		assertTrue("h".equals(stringQ.dequeue()));
		assertTrue("i".equals(stringQ.dequeue()));
		assertTrue("j".equals(stringQ.dequeue()));

	}

	@Test
	public void intEnqueueTest_LinkedListQueue() {
		Q_using_LinkedList<Integer> intQ = new Q_using_LinkedList<>();
		for (int i = 0; i < 10; i++) {
			intQ.enqueue(i);
			assertTrue(i - (intQ.getRearData()) == 0);
		}
	}

	@Test
	public void intDequeueTest_LinkedListQueue() throws Exception {
		Q_using_LinkedList<Integer> intQ = new Q_using_LinkedList<>();
		for (int i = 0; i < 10; i++) {
			intQ.enqueue(i);
		}
		for (int i = 0; i < 10; i++) {
			assertTrue(i - intQ.dequeue() == 0);
		}
	}

}
