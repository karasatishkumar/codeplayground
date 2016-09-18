package org.tat.util;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SinglyLinkedListTest {

	SinglyLinkedList<Integer> singlyLinkedList = null;

	@Before
	public void setUp() throws Exception {
		singlyLinkedList = new SinglyLinkedList<Integer>();
		for (int i = 0; i < 5; i++) {
			Node node = new Node(i);
			singlyLinkedList.insertAtEnd(node);
		}
		System.out.println(singlyLinkedList);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetHead() {
		Assert.assertTrue("Get head not working", ((int) singlyLinkedList
				.getHead().getData()) == 0);
	}

	@Test
	public void testSize() {
		Assert.assertTrue("Size is not working",
				((int) singlyLinkedList.size()) == 5);
	}

	@Test
	public void testInsertAtBeginning() {
		singlyLinkedList.insertAtBeginning(new Node(0));
		System.out.println(singlyLinkedList);
		Assert.assertEquals("Inserted value is not same as stored value", 0,
				singlyLinkedList.getHead().getData());
		Assert.assertEquals("Size of the array is not changed after insertion",
				6, singlyLinkedList.size());
	}

	@Test
	public void testInsertAtEnd() {
		singlyLinkedList.insertAtEnd(new Node(0));
		System.out.println(singlyLinkedList);
		Node temp = singlyLinkedList.getHead();
		while (temp.getNextNode() != null)
			temp = temp.getNextNode();
		Assert.assertEquals("Inserted value is inserted at the right place", 0,
				temp.getData());
		Assert.assertEquals("Size of the array is not changed after insertion",
				6, singlyLinkedList.size());
	}

	@Test
	public void testInsetAtPosition() {
		singlyLinkedList.insetAtPosition(new Node(0), 3);
		System.out.println(singlyLinkedList);
		Node temp = singlyLinkedList.getHead();
		for (int i = 0; i < 3; i++)
			temp = temp.getNextNode();
		Assert.assertEquals("Inserted value is not equal to the expexted one",
				0, temp.getData());
		Assert.assertEquals("Size of the array is not changed after insertion",
				6, singlyLinkedList.size());
	}

	@Test
	public void testInsetAtPositionFirst() {
		singlyLinkedList.insetAtPosition(new Node(0), 0);
		System.out.println(singlyLinkedList);
		Assert.assertEquals("Size of the array is not changed after insertion",
				6, singlyLinkedList.size());
	}

	@Test
	public void testInsetAtPositionLast() {
		singlyLinkedList.insetAtPosition(new Node(0), 5);
		System.out.println(singlyLinkedList);
		Assert.assertEquals("Size of the array is not changed after insertion",
				6, singlyLinkedList.size());
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testInsetAtPositionExpMinus() {
		singlyLinkedList.insetAtPosition(new Node(0), -1);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testInsetAtPositionExpInfi() {
		singlyLinkedList.insetAtPosition(new Node(0), 10);
	}

	@Test
	public void testRemoveAtBeginning() {
		Node node = singlyLinkedList.removeAtBeginning();
		System.out.println(singlyLinkedList);
		Assert.assertEquals("Inserted value is not equal to the expexted one",
				1, singlyLinkedList.getHead().getData());
		Assert.assertEquals("Size of the array is not changed after insertion",
				4, singlyLinkedList.size());
		Assert.assertEquals("Removed node value should be 0 ", 0,
				node.getData());
	}

	@Test
	public void testRemoveAtEnd() {
		Node node = singlyLinkedList.removeAtEnd();
		System.out.println(singlyLinkedList);
		Node temp = singlyLinkedList.getHead();
		while (temp.getNextNode() != null)
			temp = temp.getNextNode();
		Assert.assertEquals("Inserted value is not equal to the expexted one",
				3, temp.getData());
		Assert.assertEquals("Size of the array is not changed after insertion",
				4, singlyLinkedList.size());
		Assert.assertEquals("Removed node value should be 4 ", 4,
				node.getData());
	}

	@Test
	public void testRemoveAtIndexFirst() {
		Node node = singlyLinkedList.removeAtIndex(0);
		System.out.println(singlyLinkedList);
		Node temp = singlyLinkedList.getHead();
		Assert.assertEquals("Size of the array is not changed after insertion",
				4, singlyLinkedList.size());
		Assert.assertEquals("Removed node value should be 0 ", 0,
				node.getData());
	}

	@Test
	public void testRemoveAtIndexLast() {
		Node node = singlyLinkedList.removeAtIndex(5);
		System.out.println(singlyLinkedList);
		Node temp = singlyLinkedList.getHead();
		Assert.assertEquals("Size of the array is not changed after insertion",
				4, singlyLinkedList.size());
		Assert.assertEquals("Removed node value should be 4 ", 4,
				node.getData());
	}

	@Test
	public void testRemoveAtIndexMiddle() {
		Node node = singlyLinkedList.removeAtIndex(3);
		System.out.println(singlyLinkedList);
		Node temp = singlyLinkedList.getHead();
		Assert.assertEquals("Size of the array is not changed after insertion",
				4, singlyLinkedList.size());
		Assert.assertEquals("Removed node value should be 2 ", 2,
				node.getData());
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testRemoveAtIndexExpMinus() {
		Node node = singlyLinkedList.removeAtIndex(-1);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testRemoveAtIndexExpInfi() {
		Node node = singlyLinkedList.removeAtIndex(10);
	}

	// Find the length of the linked in a iterative way
	@Test
	public void testSizeIterative() {
		Node temp = singlyLinkedList.getHead();
		int i = 1;
		while (temp.getNextNode() != null) {
			temp = temp.getNextNode();
			i++;
		}
		Assert.assertEquals(singlyLinkedList.size(), i);
	}

	// Find the length of the linked in a recursive way
	@Test
	public void testSizeRecursive() {
		Node temp = singlyLinkedList.getHead();
		Assert.assertEquals(singlyLinkedList.size(), calculateSize(temp));
	}

	private int calculateSize(Node node) {
		int i = 1;
		if (node.getNextNode() == null) {
			return i;
		}
		i = calculateSize(node.getNextNode());
		i++;
		return i;
	}

	// Find the length of the linked in a iterative way
	@Test
	public void testSearchIterative() {
		int findValue = 3;
		boolean result = false;
		Node temp = singlyLinkedList.getHead();
		while (temp.getNextNode() != null) {
			if ((int) temp.getData() == findValue) {
				result = true;
				break;
			}
			temp = temp.getNextNode();
		}
		Assert.assertTrue(result);
	}

	// Find the length of the linked in a recursive way
	@Test
	public void testSearchRecursive() {
		Node temp = singlyLinkedList.getHead();
		Assert.assertTrue(searchRecursive(temp, 3));
	}

	private boolean searchRecursive(Node node, int value) {
		if (node.getNextNode() == null) {
			return false;
		}
		if ((int) node.getData() == value)
			return true;
		return searchRecursive(node.getNextNode(), value);
	}

	// 1) x and y may or may not be adjacent.
	// 2) Either x or y may be a head node.
	// 3) Either x or y may be last node.
	// 4) x and/or y may not be present in linked list.
	@Test
	public void testSwapNode() {
		System.out.println("Before Swap : " + singlyLinkedList);
		boolean x = singlyLinkedList.swapNode(0, 4);
		System.out.println("Swapped LinkedList : " + singlyLinkedList);
		Assert.assertTrue(x);
	}
	
	@Test(expected = RuntimeException.class)
	public void testSwapNodeNoMatch() {
		boolean x = singlyLinkedList.swapNode(0, 5);
	}

}
