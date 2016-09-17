package org.tat.util;

/**
 * 
 * @author kumark15
 * 
 * @param <T>
 */
public class SinglyLinkedList<T extends Object> {

	private int size;

	private Node head;

	public SinglyLinkedList() {
		size = 0;
	}

	public Node getHead() {
		return this.head;
	}

	public int size() {
		return this.size;
	}

	public void insertAtBeginning(Node node) {
		if (head == null)
			this.head = node;
		else {
			node.setNextNode(head);
			this.head = node;
		}
		size++;
	}

	public void insertAtEnd(Node node) {
		if (head == null)
			this.head = node;
		else {
			Node temp = this.head;
			while (temp.getNextNode() != null) temp = temp.getNextNode();
				temp.setNextNode(node);
		}
		size++;
	}

	public void insetAtPosition(Node node, int index) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Invalid index to insert");
		}

		if (index == 0) {
			this.insertAtBeginning(node);
		} else if (index == size) {
			this.insertAtEnd(node);
		} else {
			Node temp = this.head;
			for (int i = 0; i < index-1; i++) {
				temp = temp.getNextNode();
			}
			node.setNextNode(temp.getNextNode());
			temp.setNextNode(node);
			size++;
		}
	}

	public Node removeAtBeginning() {
		if (head == null)
			throw new IndexOutOfBoundsException("Empty List");
		else {
			Node temp = this.head;
			this.head = temp.getNextNode();
			temp.setNextNode(null);
			size--;
			return temp;
		}
	}

	public Node removeAtEnd() {
		if (head == null)
			throw new IndexOutOfBoundsException("Empty List");
		else {
			Node temp = head, next = temp.getNextNode();
			while (next.getNextNode() != null) {
				temp = next;
				next = next.getNextNode();
			}
			temp.setNextNode(null);
			size--;
			return next;
		}
	}

	public Node removeAtIndex(int index) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Invalid index remove");
		}

		if (index == 0) {
			return this.removeAtBeginning();
		} else if (index == size) {
			return this.removeAtEnd();
		} else {
			Node temp = this.head, prev = null;
			for (int i = 0; i < index-1; i++) {
				prev = temp;
				temp = temp.getNextNode();
			}
			prev.setNextNode(temp.getNextNode());
			temp.setNextNode(null);
			size--;
			return temp;
		}
	}

	public Node removeMatched(Node node) {
		Node temp = this.head;
		int i = 0;
		while (temp.getNextNode() != null) {
			if (temp.equals(node)) {
				return this.removeAtIndex(i);
			}
			temp = temp.getNextNode();
			i++;
		}
		return null;
	}

	public void clearList() {
		this.head = null;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		Node temp = this.head;
		while (temp.getNextNode() != null) {
			sb = sb.append(temp.getData().toString() + ",");
			temp = temp.getNextNode();
		}
		sb.append(temp.getData().toString() + "]");
		return sb.toString();
	}
	
}
