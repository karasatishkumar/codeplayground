package org.tat.util;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PriorityQueueArrayTest {
	
	PriorityQueueArray<String> test = null; 

	@Before
	public void setUp() throws Exception {
		test = new PriorityQueueArray<String>(); 
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInsert() {
		System.out.println(test);
		test.insert("satish", 1);
		System.out.println(test);
		Assert.assertEquals("satish", test.getHightestPriority());
		System.out.println(test);
		Assert.assertEquals("satish", test.removeHighestPriority());
		System.out.println(test);
	}

	@Test
	public void testGetHightestPriority() {
		System.out.println(test);
		test.insert("satish", 5);
		test.insert("raj", 3);
		test.insert("priyam", 1);
		test.insert("pooja", 2);
		test.insert("rohit", 4);
		Assert.assertEquals("priyam", test.getHightestPriority());
		System.out.println(test);
	}

	@Test
	public void testRemoveHighestPriority() {
		System.out.println(test);
		test.insert("satish", 5);
		test.insert("raj", 3);
		test.insert("priyam", 1);
		test.insert("pooja", 2);
		test.insert("rohit", 4);
		Assert.assertEquals("priyam", test.getHightestPriority());
		System.out.println(test);
		Assert.assertEquals("priyam", test.removeHighestPriority());
		System.out.println(test);
		Assert.assertEquals("pooja", test.getHightestPriority());
	}
	
	@Test(expected = RuntimeException.class)
	public void testRemoveHighestPriorityExp() {
		System.out.println(test);
		test.insert("satish", 5);
		System.out.println(test);
		test.removeHighestPriority();
		test.removeHighestPriority();
	}

}
