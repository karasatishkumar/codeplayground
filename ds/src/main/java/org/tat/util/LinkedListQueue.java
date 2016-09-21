package org.tat.util;


public class LinkedListQueue<T extends Object> {
	private SinglyLinkedList<T> store = null;
	private Node<T> rear, front;

	public LinkedListQueue() {
		store = new SinglyLinkedList<T>();
	}

	public void enqueue(T t) {
		Node<T> node = new Node<T>(t);
		if(store.getHead() == null){
			this.store.insertAtBeginning(node);
			this.front = this.store.getHead();
			this.rear = this.store.getHead();
		}else{
			this.store.insertAtEnd(node);
			this.rear = node;
		}
			
	}

	public T dequeue() {
		return (T)this.store.removeAtBeginning().getData();
	}

	public T front() {
		return (T) this.store.getHead().getData();
	}

	@Override
	public String toString() {
		return "LinkedListQueue [store=" + store + "]";
	}



}
