package org.tat.util;

public class Node<T extends Object> {
	private T data;
	private Node nextNode;
	
	public Node(T data) {
		this.data = data;
	}
	
	public T getData(){
		return this.data;
	}
	
	public Node getNextNode(){
		return this.nextNode;
	}
	
	public void setNextNode(Node nextNode){
		this.nextNode = nextNode;
	}
}
