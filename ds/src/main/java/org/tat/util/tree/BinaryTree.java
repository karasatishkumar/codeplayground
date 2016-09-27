package org.tat.util.tree;

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
		if(left != null) ret.append(left);
		ret.append(root.getData() + " ");
		String right = this.inOrderTraversal(root.getRight());
		if(right != null) ret.append(right);
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
		if(left != null) ret.append(left);
		String right = this.preOrderTraversal(root.getRight());
		if(right != null) ret.append(right);
		return ret.toString();
	}

	public String postOrderTraversal(Node<T> root) {
		StringBuffer ret = new StringBuffer();
		if (root == null)
			return null;
		org.tat.util.Node<Node<T>> element = new org.tat.util.Node<Node<T>>(
				root);
		String left = this.postOrderTraversal(root.getLeft());
		if(left != null) ret.append(left);
		String right = this.postOrderTraversal(root.getRight());
		if(right != null) ret.append(right);
		ret.append(root.getData() + " ");
		return ret.toString();
	}

	public Node<T> getRoot() {
		return root;
	}

	public void setRoot(Node<T> root) {
		this.root = root;
	}

}
