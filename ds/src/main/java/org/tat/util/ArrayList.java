package org.tat.util;

public class ArrayList<T extends Object> {

	private static final int CAPACITY = 16;
	private int size;
	private int index;
	private Object[] store;

	public ArrayList() {
		this(CAPACITY);
	}

	public ArrayList(int capacity) {
		this.size = capacity;
		this.index = -1;
		this.store = new Object[capacity];
	}

	public int size() {
		return index + 1;
	}

	public void add(T t) {
		this.add(t, index + 1);
	}

	public synchronized void add(T t, int i) {
		if (i > index + 1 || i < 0)
			throw new ArrayIndexOutOfBoundsException("invalid index");
		this.checkForSpace();
		if (i == index + 1) {
			store[++index] = t;
		} else {
			this.shiftRight(i);
			store[i] = t;
		}
	}

	public synchronized T remove(int i) {
		if (i > index + 1 || i < 0)
			throw new ArrayIndexOutOfBoundsException("invalid index");
		if (i == index) {
			T t = (T) store[i];
			store[index--] = null;
			if (index == size / 4)
				this.reduce();
			return t;
		} else {
			T t = (T) store[i];
			// left shift & reduce
			this.shiftLeft(i);
			this.reduce();
			return t;
		}
	}

	public T get(int i) {
		return (T) store[i];
	}

	// ensure capacity logic with the size check
	private void checkForSpace() {
		// create a new array of the double size
		if (index + 1 == size) {
			int newSize = size * 2;
			Object[] temp = new Object[newSize];
			// copy the old array to new array
			for (int i = 0; i <= index; i++)
				temp[i] = store[i];
			store = temp;
			size = newSize;
		}
	}

	private void reduce() {
		// create a new array half the size
		// copy the existing elements to the new array
		if (index == size / 4) {
			int newSize = size / 2;
			Object[] temp = new Object[newSize];
			// copy the old array to new array
			for (int i = 0; i <= index; i++)
				temp[i] = store[i];
			store = temp;
			size = newSize;
		}
	}

	private void shiftRight(int fromIndex) {
		for (int i = index; i != fromIndex; i--) {
			store[i + 1] = store[i];
		}
		index++;
	}

	private void shiftLeft(int toIndex) {
		for (int i = toIndex; i != index; i++) {
			store[i] = store[i + 1];
		}
		store[index--] = null;
	}

}
