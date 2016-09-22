package org.tat.util;

import java.util.Arrays;

public class PriorityQueueArray<T extends Object> {
	private static final int DEFAULT_CAPACITY = 10;
	private Item store[] = null;
	int size, index;

	public PriorityQueueArray() {
		this(DEFAULT_CAPACITY);
	}

	public PriorityQueueArray(int size) {
		this.size = size;
		this.index = -1;
		store = new Item[this.size];
	}

	public void insert(T t, int priority) {
		Item i = new Item<T>(t, priority);
		if(index == size -1)
			throw new RuntimeException("Array is full");
		store[++index] = i;
	}

	public T getHightestPriority() {
		if(this.index == -1)
			throw new RuntimeException("Array is empty");
		Item i = store[0];
		for (int j = 0; j < index; j++) {
			if(i != null && i.priority > store[j].priority)
				i = store[j];
		}
		return (T)i.t;
	}

	public T removeHighestPriority() {
		if(this.index == -1)
			throw new RuntimeException("Array is empty");
		Item i = store[0]; int k = -1;
		for (int j = 0; j < index; j++) {
			if(i != null && i.priority > store[j].priority){
				i = store[j];
				k = j;
			}
		}
		shiftLeft(k);
		index--;
		return (T)i.t;
	}
	
	private void shiftLeft(int k){
		if(k == index)
			store[k] = null;
		else if(k>-1){
			for(int i = k ; i < index ; i++){
				store[i] = store[i+1];
			}
			store[index] = null;
		}
	}

	private class Item<T extends Object> {
		private T t;
		private int priority;

		public Item(T t, int priority) {
			this.t = t;
			this.priority = priority;
		}

		@Override
		public String toString() {
			return "Item [t=" + t + ", priority=" + priority + "]";
		}
		
	}

	@Override
	public String toString() {
		return "PriorityQueueArray [store=" + Arrays.toString(store)
				+ ", size=" + size + ", index=" + index + "]";
	}
	
}
