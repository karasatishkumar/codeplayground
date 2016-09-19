package org.tat.util;

import javax.management.RuntimeErrorException;

public class Stack<T extends Object> {
	private static final int CAPACITY = 10;
	private int size;
	private int top;
	private Object[] store;
	
	public Stack() {
		this(CAPACITY);
	}
	
	public int getTop() {
		return top;
	}

	public Stack(int capacity){
		this.size = capacity;
		top = -1;
		store = new Object[capacity];
	}
	
	public void push(T t){
		if(top == this.size-1){
			throw new RuntimeException("Stack is full");
		}else{
			store[++top] = t;
		}
	}
	
	public T pop(){
		if(top == -1){
			throw new RuntimeException("Stack is empty");
		}else{
			return (T)store[top--];
		}
	}
	
	public T peek(){
		if(top == -1){
			throw new RuntimeException("Stack is empty");
		}else{
			return (T)store[top];
		}
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		for (Object o : store) {
			sb.append(((T)o) + ",");
		}
		String s = sb.substring(0, sb.length()-1);
		s = s +"]";
		return s;
	}
}
