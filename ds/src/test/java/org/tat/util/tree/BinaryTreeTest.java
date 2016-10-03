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

}
