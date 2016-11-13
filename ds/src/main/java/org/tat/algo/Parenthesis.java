package org.tat.algo;

import java.util.ArrayList;
import java.util.List;


public class Parenthesis {
	
	private static List<String> results = new ArrayList();

	public static String getCombination(String s, int left, int right){
		if(left > right)
			return "";
		if(left == 0 && right == 0){
			results.add(s);
			return s;
		}
		
		if(left > 0){
			getCombination(s+ "(", left-1, right);
		}
		
		if(right > 0){
			getCombination(s+ ")", left, right-1);
		}
		return s;
	}
	
	public static void main(String[] args) {
		Parenthesis.getCombination("", 2, 2);
		System.out.println(results);
	}
}
