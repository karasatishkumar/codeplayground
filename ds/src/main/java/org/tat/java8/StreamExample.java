package org.tat.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class StreamExample {

	public static void main(String[] args) {
		forEachExample();
		mapExample();
		filterTest();
		limitExample();
		sortExample();
	}
	
	public static void forEachExample(){
		System.out.println("--forEach() Example--");
		Random random = new Random();
		random.ints().limit(10).forEach(System.out::println);
	}
	
	public static void mapExample(){
		System.out.println("--map() Example--");
		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
		//get a list of unique squres
		List<Integer> squares = numbers.stream().map(n -> n*n).distinct().collect(Collectors.toList());
		squares.forEach(System.out::println);
	}
	
	public static void filterTest(){
		System.out.println("--filter() Example--");
		List<String> names = Arrays.asList("Satish", "Suchi", "Pooja", "Priyam", "Rohit", "Rohitash");
		names.stream().filter(name -> name.startsWith("S")).collect(Collectors.toList()).forEach(System.out::println);
	}
	
	public static void limitExample(){
		System.out.println("--limit() Example--");
		List<String> names = Arrays.asList("Satish", "Suchi", "Pooja", "Priyam", "Rohit", "Rohitash");
		names.stream().limit(3).forEach(System.out::println);
	}
	
	
	public static void sortExample(){
		System.out.println("--sort() Example--");
		List<String> names = Arrays.asList("Satish", "Suchi", "Pooja", "Priyam", "Rohit", "Rohitash");
		names.stream().sorted((s1, s2) -> s2.compareTo(s1)).forEach(System.out::println);
	}

}
