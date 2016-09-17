package org.tat.util;

public class Node {
	private Object data;
	private Node nextNode;
	
	public Node(Object data) {
		this.data = data;
	}
	
	public Object getData(){
		return this.data;
	}
	
	public Node getNextNode(){
		return this.nextNode;
	}
	
	public void setNextNode(Node nextNode){
		this.nextNode = nextNode;
	}
}
