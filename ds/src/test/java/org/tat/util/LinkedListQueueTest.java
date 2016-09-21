package org.tat.util;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LinkedListQueueTest {

	LinkedListQueue<String> aQ = null;

	@Before
	public void setUp() throws Exception {
		aQ = new LinkedListQueue<String>();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testEnqueue() {
		aQ.enqueue("Satish");
		Assert.assertEquals("Satish", aQ.front());

		System.out.println(aQ);

		aQ.enqueue("Suchismita");
		Assert.assertEquals("Satish", aQ.front());

		System.out.println(aQ);

		aQ.enqueue("Priyam");
		Assert.assertEquals("Satish", aQ.front());

		System.out.println(aQ);

		aQ.enqueue("Madhumita");
		Assert.assertEquals("Satish", aQ.front());
	}

	@Test
	public void testDequeue() {
		for (int i = 0; i < 10; i++) {
			aQ.enqueue("Satish" + i);
		}
		Assert.assertEquals("Satish0", aQ.front());
		aQ.dequeue();
		Assert.assertEquals("Satish1", aQ.front());
		aQ.dequeue();
		Assert.assertEquals("Satish2", aQ.front());
	}

	@Test
	public void testFront() {
		for (int i = 0; i < 10; i++) {
			aQ.enqueue("Satish" + i);
		}
		Assert.assertEquals("Satish0", aQ.front());
		aQ.dequeue();
		Assert.assertEquals("Satish1", aQ.front());
		aQ.enqueue("Satish");
		Assert.assertEquals("Satish1", aQ.front());
	}
}
