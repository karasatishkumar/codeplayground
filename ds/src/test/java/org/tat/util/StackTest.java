package org.tat.util;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StackTest {
	
	Stack<String> stack = new Stack<String>(5);

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPush() {
		System.out.println("1 : " + stack);
		stack.push("satish");
		System.out.println("2 : " + stack);
		Assert.assertEquals(0, stack.getTop());
		
		stack.push("priyam");
		System.out.println("3 : " + stack);
		Assert.assertEquals(1, stack.getTop());
		
		stack.push("pritam");
		System.out.println("4 : " + stack);
		Assert.assertEquals(2, stack.getTop());
		
		stack.push("pooja");
		System.out.println("5 : " + stack);
		Assert.assertEquals(3, stack.getTop());
		
		stack.push("suchi");
		System.out.println("6 : " + stack);
		Assert.assertEquals(4, stack.getTop());
	}
	
	@Test(expected = RuntimeException.class)
	public void testPuchExp(){
		System.out.println("1 : " + stack);
		stack.push("satish");
		System.out.println("2 : " + stack);
		Assert.assertEquals(0, stack.getTop());
		
		stack.push("priyam");
		System.out.println("3 : " + stack);
		Assert.assertEquals(1, stack.getTop());
		
		stack.push("pritam");
		System.out.println("4 : " + stack);
		Assert.assertEquals(2, stack.getTop());
		
		stack.push("pooja");
		System.out.println("5 : " + stack);
		Assert.assertEquals(3, stack.getTop());
		
		stack.push("suchi");
		System.out.println("6 : " + stack);
		Assert.assertEquals(4, stack.getTop());
		
		stack.push("trozan");
	}

	@Test
	public void testPop() {
		System.out.println("1 : " + stack);
		stack.push("satish");
		System.out.println("2 : " + stack);
		
		stack.push("priyam");
		System.out.println("3 : " + stack);
		
		stack.push("pritam");
		System.out.println("4 : " + stack);
		
		stack.push("pooja");
		System.out.println("5 : " + stack);
		
		stack.push("suchi");
		System.out.println("6 : " + stack);
		
		Assert.assertEquals("suchi", stack.pop());
		Assert.assertEquals(3, stack.getTop());
		
		Assert.assertEquals("pooja", stack.pop());
		Assert.assertEquals(2, stack.getTop());
		
		Assert.assertEquals("pritam", stack.pop());
		Assert.assertEquals(1, stack.getTop());
		
		Assert.assertEquals("priyam", stack.pop());
		Assert.assertEquals(0, stack.getTop());
		
		Assert.assertEquals("satish", stack.pop());
		Assert.assertEquals(-1, stack.getTop());
		
	}
	
	@Test(expected = RuntimeException.class)
	public void testPopExp() {
		System.out.println("1 : " + stack);
		stack.push("satish");
		System.out.println("2 : " + stack);
		
		stack.push("priyam");
		System.out.println("3 : " + stack);
		
		stack.push("pritam");
		System.out.println("4 : " + stack);
		
		stack.push("pooja");
		System.out.println("5 : " + stack);
		
		stack.push("suchi");
		System.out.println("6 : " + stack);
		
		Assert.assertEquals("suchi", stack.pop());
		Assert.assertEquals(3, stack.getTop());
		
		Assert.assertEquals("pooja", stack.pop());
		Assert.assertEquals(2, stack.getTop());
		
		Assert.assertEquals("pritam", stack.pop());
		Assert.assertEquals(1, stack.getTop());
		
		Assert.assertEquals("priyam", stack.pop());
		Assert.assertEquals(0, stack.getTop());
		
		Assert.assertEquals("satish", stack.pop());
		Assert.assertEquals(-1, stack.getTop());
		
		stack.pop();
	}

	@Test
	public void testPeek() {
		System.out.println("1 : " + stack);
		stack.push("satish");
		System.out.println("2 : " + stack);
		
		stack.push("priyam");
		System.out.println("3 : " + stack);
		
		stack.push("pritam");
		System.out.println("4 : " + stack);
		
		stack.push("pooja");
		System.out.println("5 : " + stack);
		
		stack.push("suchi");
		System.out.println("6 : " + stack);
		
		Assert.assertEquals("suchi", stack.peek());
		Assert.assertEquals("suchi", stack.peek());
		Assert.assertEquals("suchi", stack.peek());
		Assert.assertEquals("suchi", stack.peek());
		Assert.assertEquals("suchi", stack.peek());
	}

}
