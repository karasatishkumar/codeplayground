package org.tat.util.tree;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BinaryTreeTest {
	BinaryTree<Integer> tree = new BinaryTree<Integer>();

	@Before
	public void setUp() throws Exception {

		tree.setRoot(new Node(1));
		tree.getRoot().setLeft(new Node(2));
		tree.getRoot().setRight(new Node(3));
		tree.getRoot().getLeft().setLeft(new Node(4));
		tree.getRoot().getLeft().setRight(new Node(5));
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInOrderTraversal() {
		Assert.assertEquals("4 2 5 1 3 ", tree.inOrderTraversal(tree.getRoot()));
	}

	@Test
	public void testPreOrderTraversal() {
		Assert.assertEquals("1 2 4 5 3 ",
				tree.preOrderTraversal(tree.getRoot()));
	}

	@Test
	public void testPostOrderTraversal() {
		Assert.assertEquals("4 5 2 3 1 ",
				tree.postOrderTraversal(tree.getRoot()));
	}

	@Test
	public void testHeight() {
		Assert.assertEquals(3, tree.height(tree.getRoot()));
	}

	@Test
	public void testLevelOrderTraversal() {
		Assert.assertEquals("1 2 3 4 5 ", tree.levelOrderTraversal());
	}

	@Test
	public void testLevelOrderTraversalWithQueue() {
		Assert.assertEquals("1 2 3 4 5 ", tree.levelOrderTraversalWithQueue());
	}

	@Test
	public void testDiameterON2() {
		Assert.assertEquals(4, tree.diameterON2(tree.getRoot()));
	}

	@Test
	public void testSearch() {
		tree = new BinaryTree<Integer>();
		tree.setRoot(new Node(6));
		tree.getRoot().setLeft(new Node(4));
		tree.getRoot().setRight(new Node(7));
		tree.getRoot().getLeft().setLeft(new Node(3));
		tree.getRoot().getLeft().setRight(new Node(5));
		Node<Integer> node= tree.search(tree.getRoot(), 7);
		Assert.assertEquals(7, (int)node.getData());
	}
	
	@Test
	public void testInsert() {
		tree = new BinaryTree<Integer>();
		tree.setRoot(new Node(6));
		tree.getRoot().setLeft(new Node(4));
		tree.getRoot().setRight(new Node(8));
		tree.getRoot().getLeft().setLeft(new Node(3));
		tree.getRoot().getLeft().setRight(new Node(5));
		tree.insert(7);
		Assert.assertEquals("3 4 5 6 7 8 ", tree.inOrderTraversal(tree.getRoot()));
	}
	
	@Test(expected=RuntimeException.class)
	public void testInsertExp() {
		tree = new BinaryTree<Integer>();
		tree.setRoot(new Node(6));
		tree.getRoot().setLeft(new Node(4));
		tree.getRoot().setRight(new Node(8));
		tree.getRoot().getLeft().setLeft(new Node(3));
		tree.getRoot().getLeft().setRight(new Node(5));
		tree.insert( 5);
		Assert.assertEquals("3 4 5 6 7 8 ", tree.inOrderTraversal(tree.getRoot()));
	}
	
	@Test
	public void testDelete() {
		tree = new BinaryTree<Integer>();
		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);
		System.out.println(tree.inOrderTraversal(tree.getRoot()));
		tree.delete(20);
		System.out.println(tree.inOrderTraversal(tree.getRoot()));
		Assert.assertEquals("30 40 50 60 70 80 ", tree.inOrderTraversal(tree.getRoot()));
		tree.delete(30);
		System.out.println(tree.inOrderTraversal(tree.getRoot()));
		Assert.assertEquals("40 50 60 70 80 ", tree.inOrderTraversal(tree.getRoot()));
		tree.delete(50);
		System.out.println(tree.inOrderTraversal(tree.getRoot()));
		Assert.assertEquals("40 60 70 80 ", tree.inOrderTraversal(tree.getRoot()));
	}
}
