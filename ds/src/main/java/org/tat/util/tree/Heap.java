package org.tat.util.tree;

import java.util.Arrays;

public class Heap<T extends Object & Comparable> {
	private Object[] store;
	private Type type;
	private int index;
	private int size;

	public Heap(Type type) {
		this(type, 10);
	}

	public Heap(Type type, int size) {
		this.store = new Object[size];
		this.index = -1;
		this.type = type;
		this.size = size;
	}

	public void insert(T key) {
		if (index == size - 1)
			throw new RuntimeException("Space is full");
		this.store[++index] = key;
		this.heapify(index, Operation.INSERT);
	}

	private void heapify(int i, Operation operation) {
		if (operation == Operation.INSERT) {
			if (this.type == Type.MIN) {
				while (i != 0 && ((T) store[getParent(i)]).compareTo((T) store[i]) > 0) {
					this.swap(i, getParent(i));
					i = getParent(i);
				}
			} else {
				while (i != 0 && ((T) store[getParent(i)]).compareTo((T) store[i]) < 0) {
					this.swap(i, getParent(i));
					i = getParent(i);
				}
			}
		} else {
			if (this.type == Type.MIN) {
				while (i != this.index) {
					
					this.swap(i, getParent(i));
					i = getParent(i);
				}
			} else {
				while (i != 0 && ((T) store[getParent(i)]).compareTo((T) store[i]) < 0) {
					this.swap(i, getParent(i));
					i = getParent(i);
				}
			}
		}
	}

	private int getParent(int child) {
		return (child - 1) / 2;
	}

	private int getLeft(int parent) {
		return 2 * parent + 1;
	}

	private int getRight(int parent) {
		return 2 * parent + 2;
	}

	private void swap(int i, int j) {
		T temp = (T) store[i];
		store[i] = store[j];
		store[j] = temp;
	}

	public void delete(T key) {
		int i = 0;
		while (i >= this.index) {
			if (((T) store[i]).compareTo(key) == 0) {
				this.swap(i, this.index);
				store[index--] = null;
				break;
			}
			i++;
		}
		this.heapify(i, Operation.DELETE);

	}

	public Object[] getStore() {
		return store;
	}

	public Type getType() {
		return type;
	}

	public int getIndex() {
		return index;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Heap [store=" + Arrays.toString(store) + " index=" + index;
	}

	private enum Operation {
		INSERT, DELETE
	}
}

enum Type {
	MAX, MIN
}
