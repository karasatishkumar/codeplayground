package org.tat.util;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArrayQueueTest {
	
	ArrayQueue<String> aQ = null;

	@Before
	public void setUp() throws Exception {
		aQ = new ArrayQueue<String>();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testEnqueue() {
		aQ.enqueue("Satish");
		Assert.assertEquals(0, aQ.getFront());
		Assert.assertEquals(0, aQ.getRear());
		
		System.out.println(aQ);
		
		aQ.enqueue("Suchismita");
		Assert.assertEquals(0, aQ.getFront());
		Assert.assertEquals(1, aQ.getRear());
		
		System.out.println(aQ);
		
		aQ.enqueue("Priyam");
		Assert.assertEquals(0, aQ.getFront());
		Assert.assertEquals(2, aQ.getRear());
		
		System.out.println(aQ);
		
		aQ.enqueue("Madhumita");
		Assert.assertEquals(0, aQ.getFront());
		Assert.assertEquals(3, aQ.getRear());
	}
	
	@Test(expected = RuntimeException.class)
	public void testEnqueueExp() {
		for(int i = 0 ; i < 10 ; i++){
			aQ.enqueue("Satish"+i);
		}
		aQ.enqueue("Satish");
	}

	@Test
	public void testDequeue() {
		for(int i = 0 ; i < 10 ; i++){
			aQ.enqueue("Satish"+i);
		}
		Assert.assertEquals(0, aQ.getFront());
		Assert.assertEquals(9, aQ.getRear());
		aQ.dequeue();
		Assert.assertEquals(1, aQ.getFront());
		Assert.assertEquals(9, aQ.getRear());
		aQ.dequeue();
		Assert.assertEquals(2, aQ.getFront());
		Assert.assertEquals(9, aQ.getRear());
	}
	
	@Test(expected = RuntimeException.class)
	public void testDequeueExp() {
		aQ.dequeue();
	}

	@Test
	public void testFront() {
		for(int i = 0 ; i < 10 ; i++){
			aQ.enqueue("Satish"+i);
		}
		Assert.assertEquals("Satish0", aQ.front());
		aQ.dequeue();
		Assert.assertEquals("Satish1", aQ.front());
		aQ.enqueue("Satish");
		Assert.assertEquals("Satish1", aQ.front());
	}

}
