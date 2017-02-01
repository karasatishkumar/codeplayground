package org.tat.algo;

public class StringIndexOf {
	public static boolean ifPresent(String first, String second) {
		int j = 0 ;
		for (int i = 0; i < first.length(); i++) {
			if (first.charAt(i) == second.charAt(j)) {
				//System.out.println(first.charAt(i) + " : " + second.charAt(j));
				j++;
				if(j == second.length())
					return true;
			} else {
				j = 0;
			}

		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println("is satish contains in satishkumar : "
				+ ifPresent("satishkumar", "satish"));
		
		System.out.println("is satish contains in karasatishkumar : "
				+ ifPresent("karasatishkumar", "satish"));
		System.out.println("is sathish contains in karasatishkumar : "
				+ ifPresent("karasatishkumar", "sathish"));
	}
}
