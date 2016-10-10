package org.tat.util.tree;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HeapTest {
	
	private Heap<Integer> heap;

	@Before
	public void setUp() throws Exception {
		heap = new Heap<>(Type.MAX);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInsert() {
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
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

}
