package org.tat.java8;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class ParallelStreamExample {
	public static void main(String[] args) {
		countExample();
		collectorsExample();
		statisticsExample();
	}
	
	public static void countExample(){
		System.out.println("--count() Example--");
		List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
		//get count of empty string
		long count = strings.parallelStream().filter(string -> string.equals("")).count();
		System.out.println("No of empty strings : " + count);
	}
	
	public static void collectorsExample(){
		System.out.println("--collectors Example--");
		List<String>strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
		List<String> filtered = strings.parallelStream().filter(string -> !string.isEmpty()).collect(Collectors.toList());

		System.out.println("Filtered List: " + filtered);
		String mergedString = strings.parallelStream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
		System.out.println("Merged String: " + mergedString);
	}
	
	public static void statisticsExample(){
		System.out.println("--Statistics examples--");
		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

		IntSummaryStatistics stats = numbers.parallelStream().mapToInt((x) -> x).summaryStatistics();

		System.out.println("Highest number in List : " + stats.getMax());
		System.out.println("Lowest number in List : " + stats.getMin());
		System.out.println("Sum of all numbers : " + stats.getSum());
		System.out.println("Average of all numbers : " + stats.getAverage());
	}
}
