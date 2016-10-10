package org.tat.util.tree;

public class Heap <T extends Object & Comparable>{
	private Node<T> root;
	private Type type;
	
	public Heap(Type type) {
		root = null;
		this.type = type;
	}
	
	public void insert(T key){
		Node<T> temp = this.insertRec(this.root, key);
		this.root = temp;
	}
	
	public Node<T> insertRec(Node<T> root, T key){
		if(root == null){
			root = new Node<T>(key);
			return root;
		}
		if(root.getLeft() == null)
			root.setLeft(insertRec(root.getLeft(), key));
		else
			if(root.getRight() == null)
				root.setRight(insertRec(root.getRight(), key));
			else
				root.setLeft(insertRec(root.getLeft(), key));
		return root;
	}
	
	public void delete(T key){
		
	}
}
enum Type{
	MAX, MIN
}
