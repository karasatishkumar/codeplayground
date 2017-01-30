package org.tat.algo;

public class StringReversal {
	
	public static String reverse(String input){
		if(input.length() == 1)
			return input;
		return reverse(input.substring(1))+input.charAt(0);
	}
	
	public static void reversePrint(String input){
		if(input.length() == 0){
			return;
		}
		reversePrint(input.substring(1));
		System.out.print(input.charAt(0));
	}
	
	public static void main(String[] args) {
		System.out.println(reverse("satish"));
		System.out.println();
		reversePrint("suchi");
	}
}
