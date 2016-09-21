package org.tat.util;

import java.util.Arrays;

/**
 * Queue implementation using circular array
 * 
 * @author Satish
 * 
 * @param <T>
 */
public class ArrayQueue<T extends Object> {
	private static final int DEFAULT_CAPACITY = 10;
	private Object[] store;
	private int front, rear, size;

	public ArrayQueue() {
		this(DEFAULT_CAPACITY);
	}

	public ArrayQueue(int capacity) {
		this.size = capacity;
		this.front = -1;
		this.rear = -1;
		this.store = new Object[capacity];
	}

	public void enqueue(T t) {
		if (isFull())
			throw new RuntimeException("Queue is full");
		else if (isEmpty()) {
			front = 0;
			rear = 0;
		} else {
			rear = (rear + 1) % this.size;
		}
		this.store[rear] = t;
	}

	public T dequeue() {
		if (isEmpty())
			throw new RuntimeException("Queue is empty");
		else if (front == rear) {
			front = -1;
			rear = -1;
		} else {
			front = (front + 1) % this.size;
		}
		return (T) this.store[front];
	}

	public T front() {
		return (T) this.store[this.front];
	}

	public boolean isEmpty() {
		if (this.front == -1 && this.rear == -1)
			return true;
		return false;
	}

	public boolean isFull() {
		if ((this.rear + 1) % size == this.front)
			return true;
		return false;

	}

	@Override
	public String toString() {
		return "ArrayQueue [store=" + Arrays.toString(store) + ", front="
				+ front + ", rear=" + rear + "]";
	}

	public int getFront() {
		return front;
	}

	public int getRear() {
		return rear;
	}

}
