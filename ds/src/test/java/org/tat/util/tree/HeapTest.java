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

	@Test(expected = RuntimeException.class)
	public void testDeleteExp() {
		heap = new Heap<>(Type.MIN);
		heap.delete(5);
	}
	
	@Test
	public void testDelete1() {
		heap = new Heap<>(Type.MIN);
		heap.insert(1);
		heap.insert(2);
		heap.insert(3);
		heap.insert(4);
		heap.insert(5);
		heap.delete(5);
		Assert.assertEquals(heap.getStore(), new Object[]{1, 2, 3, 4, null, null, null, null, null, null});
	}
	
	@Test
	public void testDelete2() {
		heap = new Heap<>(Type.MIN);
		heap.insert(1);
		heap.insert(2);
		heap.insert(3);
		heap.insert(4);
		heap.insert(5);
		heap.delete(1);
		Assert.assertEquals(heap.getStore(), new Object[]{2, 5, 3, 4, null, null, null, null, null, null});
	}
	
	@Test
	public void testDelete3() {
		heap = new Heap<>(Type.MAX);
		heap.insert(1);
		heap.insert(2);
		heap.insert(3);
		heap.insert(4);
		heap.insert(5);
		heap.delete(5);
		Assert.assertEquals(heap.getStore(), new Object[]{4, 3, 2, 1, null, null, null, null, null, null});
	}
	
	@Test
	public void testDelete4() {
		heap = new Heap<>(Type.MAX);
		heap.insert(1);
		heap.insert(2);
		heap.insert(3);
		heap.insert(4);
		heap.insert(5);
		heap.delete(1);
		Assert.assertEquals(heap.getStore(), new Object[]{ 5, 4, 2, 3, null, null, null, null, null, null});
	}

}
