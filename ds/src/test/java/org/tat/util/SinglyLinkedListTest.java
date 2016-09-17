package org.tat.util;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SinglyLinkedListTest {
	
	SinglyLinkedList<String> singlyLinkedList = null;

	@Before
	public void setUp() throws Exception {
		singlyLinkedList = new SinglyLinkedList<String>();
		for(int i =0 ; i < 5 ; i++){
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
		Assert.assertTrue("Get head not working", ((int)singlyLinkedList.getHead().getData())==0);
	}

	@Test
	public void testSize() {
		Assert.assertTrue("Size is not working", ((int)singlyLinkedList.size())==5);
	}

	@Test
	public void testInsertAtBeginning() {
		singlyLinkedList.insertAtBeginning(new Node(0));
		System.out.println(singlyLinkedList);
		Assert.assertEquals("Inserted value is not same as stored value",0, singlyLinkedList.getHead().getData());
		Assert.assertEquals("Size of the array is not changed after insertion",6, singlyLinkedList.size());
	}

	@Test
	public void testInsertAtEnd() {
		singlyLinkedList.insertAtEnd(new Node(0));
		System.out.println(singlyLinkedList);
		Node temp = singlyLinkedList.getHead();
		while(temp.getNextNode() != null) temp = temp.getNextNode();
		Assert.assertEquals("Inserted value is inserted at the right place", 0, temp.getData());
		Assert.assertEquals("Size of the array is not changed after insertion",6, singlyLinkedList.size());
	}

	@Test
	public void testInsetAtPosition() {
		singlyLinkedList.insetAtPosition(new Node(0), 3);
		System.out.println(singlyLinkedList);
		Node temp = singlyLinkedList.getHead();
		for(int i = 0; i < 3 ; i++) temp = temp.getNextNode();
		Assert.assertEquals("Inserted value is not equal to the expexted one", 0, temp.getData());
		Assert.assertEquals("Size of the array is not changed after insertion",6, singlyLinkedList.size());
	}
	
	@Test
	public void testInsetAtPositionFirst() {
		singlyLinkedList.insetAtPosition(new Node(0), 0);
		System.out.println(singlyLinkedList);
		Assert.assertEquals("Size of the array is not changed after insertion",6, singlyLinkedList.size());
	}
	
	@Test
	public void testInsetAtPositionLast() {
		singlyLinkedList.insetAtPosition(new Node(0), 5);
		System.out.println(singlyLinkedList);
		Assert.assertEquals("Size of the array is not changed after insertion",6, singlyLinkedList.size());
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
		Assert.assertEquals("Inserted value is not equal to the expexted one", 1, singlyLinkedList.getHead().getData());
		Assert.assertEquals("Size of the array is not changed after insertion",4, singlyLinkedList.size());
		Assert.assertEquals("Removed node value should be 0 ",0, node.getData());
	}

	@Test
	public void testRemoveAtEnd() {
		Node node = singlyLinkedList.removeAtEnd();
		System.out.println(singlyLinkedList);
		Node temp = singlyLinkedList.getHead();
		while(temp.getNextNode() != null) temp = temp.getNextNode();
		Assert.assertEquals("Inserted value is not equal to the expexted one", 3, temp.getData());
		Assert.assertEquals("Size of the array is not changed after insertion", 4, singlyLinkedList.size());
		Assert.assertEquals("Removed node value should be 4 ",4, node.getData());
	}

	@Test
	public void testRemoveAtIndexFirst() {
		Node node = singlyLinkedList.removeAtIndex(0);
		System.out.println(singlyLinkedList);
		Node temp = singlyLinkedList.getHead();
		Assert.assertEquals("Size of the array is not changed after insertion", 4, singlyLinkedList.size());
		Assert.assertEquals("Removed node value should be 0 ",0, node.getData());
	}
	
	@Test
	public void testRemoveAtIndexLast() {
		Node node = singlyLinkedList.removeAtIndex(5);
		System.out.println(singlyLinkedList);
		Node temp = singlyLinkedList.getHead();
		Assert.assertEquals("Size of the array is not changed after insertion", 4, singlyLinkedList.size());
		Assert.assertEquals("Removed node value should be 4 ",4, node.getData());
	}
	
	@Test
	public void testRemoveAtIndexMiddle() {
		Node node = singlyLinkedList.removeAtIndex(3);
		System.out.println(singlyLinkedList);
		Node temp = singlyLinkedList.getHead();
		Assert.assertEquals("Size of the array is not changed after insertion", 4, singlyLinkedList.size());
		Assert.assertEquals("Removed node value should be 2 ",2, node.getData());
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testRemoveAtIndexExpMinus() {
		Node node = singlyLinkedList.removeAtIndex(-1);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testRemoveAtIndexExpInfi() {
		Node node = singlyLinkedList.removeAtIndex(10);
	}

}
