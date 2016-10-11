package org.tat.util.tree;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class HeapTest {
	
	private Heap<Integer> heap;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test(expected = RuntimeException.class)
	public void testInsertExpMin() {
		heap = new Heap<>(Type.MIN);
		heap.insert(1);
		heap.insert(2);
		heap.insert(3);
		heap.insert(4);
		heap.insert(5);
		heap.insert(6);
		heap.insert(7);
		heap.insert(8);
		heap.insert(9);
		heap.insert(10);
		heap.insert(11);
		heap.insert(12);
		System.out.println(heap);
	}
	
	@Test
	public void testInsert1Min() {
		heap = new Heap<>(Type.MIN);
		heap.insert(1);
		heap.insert(2);
		heap.insert(3);
		heap.insert(4);
		heap.insert(5);
		heap.insert(6);
		heap.insert(7);
		heap.insert(8);
		heap.insert(9);
		heap.insert(10);
		Assert.assertEquals(heap.getStore(), new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
	}
	
	@Test
	public void testInsert2Min() {
		heap = new Heap<>(Type.MIN);
		heap.insert(2);
		heap.insert(4);
		heap.insert(3);
		heap.insert(10);
		heap.insert(6);
		heap.insert(8);
		heap.insert(5);
		heap.insert(1);
		heap.insert(9);
		heap.insert(7);
		Assert.assertEquals(heap.getStore(), new Object[]{1, 2, 3, 4, 6, 8, 5, 10, 9, 7});
	}
	
	@Test(expected = RuntimeException.class)
	public void testInsertExpMax() {
		heap = new Heap<>(Type.MAX);
		heap.insert(1);
		heap.insert(2);
		heap.insert(3);
		heap.insert(4);
		heap.insert(5);
		heap.insert(6);
		heap.insert(7);
		heap.insert(8);
		heap.insert(9);
		heap.insert(10);
		heap.insert(11);
		heap.insert(12);
		System.out.println(heap);
	}
	
	@Test
	public void testInsert1Max() {
		heap = new Heap<>(Type.MAX);
		heap.insert(1);
		heap.insert(2);
		heap.insert(3);
		heap.insert(4);
		heap.insert(5);
		heap.insert(6);
		heap.insert(7);
		heap.insert(8);
		heap.insert(9);
		heap.insert(10);
		Assert.assertEquals(heap.getStore(), new Object[]{10, 9, 6, 7, 8, 2, 5, 1, 4, 3});
	}
	
	@Test
	public void testInsert2Max() {
		heap = new Heap<>(Type.MAX);
		heap.insert(2);
		heap.insert(4);
		heap.insert(3);
		heap.insert(10);
		heap.insert(6);
		heap.insert(8);
		heap.insert(5);
		heap.insert(1);
		heap.insert(9);
		heap.insert(7);
		Assert.assertEquals(heap.getStore(), new Object[]{10, 9, 8, 6, 7, 3, 5, 1, 2, 4});
	}

	//@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

}
