package org.tat.algo;

import java.util.ArrayList;
import java.util.List;


public class StringCombinations {
	
	private static List<String> result = new ArrayList<>();
	
	public static String combination(String s, int left, int right){
		if(right == left){
			result.add(s);
			return s;
		}
		
		return combination(s, left - 1, right);
			
	}
	
	public static void swap(String string, int i, int j){
		
	}
	
	public static void main(String[] args) {
		combination("ABC", 0, 3);
		System.out.println(result);
	}
}
