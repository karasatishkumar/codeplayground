package org.tat.algo.greedy;

public class ActivitySelectionGreedy {
	public static void printMaxActivities(int s[], int f[], int n){
		int i = 0, j = 0;
		
		//n - no of activities
		//s[] - list of start times
		//f[] - list of end times
		
		//by default select the first item and print
		System.out.print(j + " ");
		
		for (j = 1; j < n; j++) {
			if(s[j] >= f[i]){
				System.out.print(j + " ");
				i = j;
			}
		}
	}
	public static void main(String[] args) {
		int s[] =  {1, 3, 0, 5, 8, 5};
	    int f[] =  {2, 4, 6, 7, 9, 9};
	    int n = s.length;
	        
	    printMaxActivities(s, f, n);
	    
	}
}
