package org.tat.java8;

import java.util.ArrayList;
import java.util.List;
class Printer{
	public void print(String s){
		System.out.println(s);
	}
}
public class PrintlnRef {
	public static void main(String[] args) {
		List<String> names = new ArrayList<String>();
		names.add("Satish");
		names.add("Pooja");
		names.add("Priyam");
		names.add("Rohit");
		
		//Passing arguments to sop
		names.forEach(System.out::println);
		//passing arguments to static method
		names.forEach(PrintlnRef::print);
		
		//passing an instance method
		Printer p = new Printer();
		names.forEach(p::print);
		
		//labda expression - example of functional interface
		names.forEach(s -> System.out.println(s));
	}
	
	static void print(String s){
		System.out.println(s);
	}
}
