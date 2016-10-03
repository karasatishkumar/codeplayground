package org.tat.util.tree;

public class Node<T extends Object & Comparable>{
	private T data;
	private Node<T> left;
	private Node<T> right;

	public Node(T data) {
		this.data = data;
		left = right = null;
	}

	@Override
	public String toString() {
		return data.toString();
	}

	public T getData() {
		return data;
	}

	public Node<T> getLeft() {
		return left;
	}

	public Node<T> getRight() {
		return right;
	}

	public void setLeft(Node<T> left) {
		this.left = left;
	}

	public void setRight(Node<T> right) {
		this.right = right;
	}


}
