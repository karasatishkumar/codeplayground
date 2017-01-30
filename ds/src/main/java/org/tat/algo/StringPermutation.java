package org.tat.algo;

import java.util.ArrayList;
import java.util.List;


public class StringPermutation {
	
	private static List<String> result = new ArrayList<>();
	
	public static void permutation(String prefix, String sufix){
		if(sufix.isEmpty()){
			result.add(prefix);
		}
		
		for(int i = 0 ; i < sufix.length();i++){
			permutation(prefix + sufix.charAt(i), sufix.substring(0, i) + sufix.substring(i+1, sufix.length()));
		}
		
			
	}
	
	public static void swap(String string, int i, int j){
		
	}
	
	public static void main(String[] args) {
		permutation("", "ABCDE");
		System.out.println(result);
	}
}
