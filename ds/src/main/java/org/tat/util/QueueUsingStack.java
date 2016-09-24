package org.tat.util;

public class QueueUsingStack <T extends Object>{
	private Stack<T> stack1, stack2;
	
	public QueueUsingStack() {
		stack1 = new Stack<T>();
		stack2 = new Stack<T>();
	}
	
	public void enQueue(T t){
		if(stack1.getTop() == -1){
			stack1.push(t);
		}else{
			while(stack1.getTop() != -1){
				stack2.push(stack1.pop());
			}
			stack1.push(t);
			while(stack2.getTop() != -1){
				stack1.push(stack2.pop());
			}
		}
	}
	
	public T deQueue(){
		return stack1.pop();
	}

	@Override
	public String toString() {
		return "QueueUsingStack [stack1=" + stack1 + ", stack2=" + stack2 + "]";
	}
	
}
