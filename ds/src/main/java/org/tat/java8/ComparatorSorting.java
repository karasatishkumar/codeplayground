package org.tat.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorSorting {
	
	
	public static void main(String[] args) {
		List<String> names = new ArrayList<String>();
		
		names.add("Satish");
		names.add("Priyam");
		names.add("Pooja");
		names.add("Rohit");
		
		sortJava7(names);
		
		System.out.println(names);
		
		sortJava8(names);
		
		System.out.println(names);
		
	}

	public static void sortJava7(List<String> list) {
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}

		});
	}
	
	public static void sortJava8(List<String> list) {
		Collections.sort(list, (s1, s2) -> s1.compareTo(s2));
	}

}
