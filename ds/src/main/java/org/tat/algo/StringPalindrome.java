package org.tat.algo;

public class StringPalindrome {
	public static boolean palindrome(String input){
		for(int i = 0, j = input.length()-1; i <= j;i++,j--){
			//System.out.println("i : " + i + " j : " + j);
			if(input.charAt(i) != input.charAt(j))
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println("Is satish palindrom? : " + palindrome("satish") );
		System.out.println("Is madam palindrom ? " + palindrome("madam"));
		System.out.println("Is raddar palindrom? " + palindrome("raddar"));
	}
}
