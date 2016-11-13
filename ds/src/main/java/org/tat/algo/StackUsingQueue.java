package org.tat.algo;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {

	private static Queue<String> queue1 = new LinkedList<String>();
	private static Queue<String> queue2 = new LinkedList<String>();

	public static void push(String input) {
		if(queue1.size() == 0){
			queue1.add(input);
			fill(queue2, queue1);
		}else{
			queue2.add(input);
			fill(queue1, queue2);
		}
	}
	
	private static void fill(Queue<String> source, Queue<String> dest){
		while(source.size() > 0){
			dest.add(source.poll());
		}
	}

	public static String pop() {
		if(queue1.size() > 0){
			return queue1.poll();
		}else{
			return queue2.poll();
		}
	}

	public static String peek() {
		if(queue1.size() > 0){
			return queue1.peek();
		}else{
			return queue2.peek();
		}
	}

	public static void main(String[] args) {
		push("satish");
		push("rohit");
		push("pooja");
		push("priyam");
		
		System.out.println(queue1);
		System.out.println(queue2);
		
		System.out.println("Pop : " + pop());
		System.out.println("Peek : " + peek());
		System.out.println("Pop : " + pop());
		System.out.println("Pop : " + pop());
		System.out.println("Pop : " + pop());
	}
}
