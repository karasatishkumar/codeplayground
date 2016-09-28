package org.tat.util.tree;

import org.tat.util.LinkedListQueue;
import org.tat.util.SinglyLinkedList;

public class BinaryTree<T extends Object> {
	private Node<T> root;

	public BinaryTree() {
		this.root = null;
	}

	public BinaryTree(T data) {
		this.root = new Node<T>(data);
	}

	public String inOrderTraversal(Node<T> root) {
		StringBuffer ret = new StringBuffer();
		if (root == null)
			return null;
		org.tat.util.Node<Node<T>> element = new org.tat.util.Node<Node<T>>(
				root);
		String left = this.inOrderTraversal(root.getLeft());
		if (left != null)
			ret.append(left);
		ret.append(root.getData() + " ");
		String right = this.inOrderTraversal(root.getRight());
		if (right != null)
			ret.append(right);
		return ret.toString();
	}

	public String preOrderTraversal(Node<T> root) {
		StringBuffer ret = new StringBuffer();
		if (root == null)
			return null;
		org.tat.util.Node<Node<T>> element = new org.tat.util.Node<Node<T>>(
				root);
		ret.append(root.getData() + " ");
		String left = this.preOrderTraversal(root.getLeft());
		if (left != null)
			ret.append(left);
		String right = this.preOrderTraversal(root.getRight());
		if (right != null)
			ret.append(right);
		return ret.toString();
	}

	public String postOrderTraversal(Node<T> root) {
		StringBuffer ret = new StringBuffer();
		if (root == null)
			return null;
		org.tat.util.Node<Node<T>> element = new org.tat.util.Node<Node<T>>(
				root);
		String left = this.postOrderTraversal(root.getLeft());
		if (left != null)
			ret.append(left);
		String right = this.postOrderTraversal(root.getRight());
		if (right != null)
			ret.append(right);
		ret.append(root.getData() + " ");
		return ret.toString();
	}

	public Node<T> getRoot() {
		return root;
	}

	public void setRoot(Node<T> root) {
		this.root = root;
	}

	public int height(Node<T> root) {
		if (root == null)
			return 0;
		int lheight = height(root.getLeft());
		int rheight = height(root.getRight());
		if (lheight > rheight)
			return lheight + 1;
		else
			return rheight + 1;
	}

	public String levelOrderTraversal() {
		String ret = "";
		for (int i = 1; i <= this.height(root); i++) {
			ret += this.getGivenLevelNodes(root, i);
		}
		return ret;
	}

	private String getGivenLevelNodes(Node<T> node, int level) {
		if (node == null) {
			return "";
		}
		String ret = "";
		if (level == 1) {
			return node.getData().toString() + " ";
		} else {
			ret += this.getGivenLevelNodes(node.getLeft(), level - 1);
			ret += this.getGivenLevelNodes(node.getRight(), level - 1);
		}
		return ret;
	}

	public String levelOrderTraversalWithQueue() {
		LinkedListQueue<Node> queue = new LinkedListQueue<Node>();
		String ret = "";
		queue.enqueue(root);
		while (queue.front() != null) {

			Node tempNode = queue.dequeue();
			ret += tempNode.getData().toString() + " ";

			/* Enqueue left child */
			if (tempNode.getLeft() != null) {
				queue.enqueue(tempNode.getLeft());
			}

			/* Enqueue right child */
			if (tempNode.getRight() != null) {
				queue.enqueue(tempNode.getRight());
			}
		}
		return ret;
	}
	
	public int diameterON2(Node<T> root){
		if(root == null)
			return 0;
		
		int lHeight = this.height(root.getLeft());
		int rHeight = this.height(root.getRight());
		
		int lDia = this.diameterON2(root.getLeft());
		int rDia = this.diameterON2(root.getRight());
		
		return Math.max(lHeight + rHeight + 1, Math.max(lDia, rDia));
	}
}
