package org.tat.util;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class QueueUsingStackTest {
	
	QueueUsingStack<String> test;

	@Before
	public void setUp() throws Exception {
		test = new QueueUsingStack<String>();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testEnQueue() {
		test.enQueue("satish");
		Assert.assertEquals("satish", test.deQueue());
		test.enQueue("priyam");
		test.enQueue("suchi");
		Assert.assertEquals("priyam", test.deQueue());
	}

	@Test
	public void testDeQueue() {
		test.enQueue("priyam");
		test.enQueue("suchi");
		test.enQueue("pooja");
		test.enQueue("madhumita");
		Assert.assertEquals("priyam", test.deQueue());
		Assert.assertEquals("suchi", test.deQueue());
		Assert.assertEquals("pooja", test.deQueue());
		Assert.assertEquals("madhumita", test.deQueue());
	}

}
