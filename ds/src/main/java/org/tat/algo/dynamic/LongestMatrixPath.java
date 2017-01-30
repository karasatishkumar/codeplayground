package org.tat.algo.dynamic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class LongestMatrixPath {
	private static Map<String, Integer> memory = new HashMap<>();
	private static List<String> vistited = new ArrayList<>();
	private static int x_max = 4;
	private static int y_max = 4;
	public static void main(String[] args) {
		
		int[][] matrix = new int[x_max][y_max];
		
		for(int i = 0 ; i < x_max ; i++){
			for(int j = 0 ; j < y_max ; j++){
				matrix[i][j] = 1;
			}
		}
		
		System.out.println("Longest Path : " + getLongestPath(0,0, matrix));
	}
	
	public static int getLongestPath(int x,int y, int[][] matrix){
		
		//System.out.println(" x : " + x + " y : " + y);
		//System.out.println("Map : " + memory);
		
		if(x < 0 || y < 0 || x == x_max || y == y_max || matrix[x][y] == 0 || vistited.contains(x+""+y)){
			System.out.println("stoping condition : x : " + x + " y : " + y);
			//memory.put((x)+""+(y), 0);
			return 0;
		}
		int path = 0;
		
		vistited.add(x + "" + y);
		
		List<Integer> results = new ArrayList<>();
		
		if(memory.containsKey((x-1)+""+(y-1)))
			path = memory.get((x-1)+""+(y-1));
		else{
			path = getLongestPath(x-1,y-1,matrix);
			memory.put((x-1)+""+(y-1), path);
		}
		
		results.add(path);
		
		if(memory.containsKey((x)+""+(y-1)))
			path = memory.get((x)+""+(y-1));
		else{
			path = getLongestPath(x,y-1,matrix);
			memory.put((x)+""+(y-1), path);
		}
		
		results.add(path);
		
		if(memory.containsKey((x+1)+""+(y-1)))
			path = memory.get((x+1)+""+(y-1));
		else{
			path = getLongestPath(x+1,y-1,matrix);
			memory.put((x+1)+""+(y-1), path);
		}
		
		results.add(path);
		
		if(memory.containsKey((x+1)+""+(y)))
			path = memory.get((x+1)+""+(y));
		else{
			path = getLongestPath(x+1,y,matrix);
			memory.put((x+1)+""+(y), path);
		}
		
		results.add(path);
		
		if(memory.containsKey((x+1)+""+(y+1)))
			path = memory.get((x+1)+""+(y+1));
		else{
			path = getLongestPath(x+1,y+1,matrix);
			memory.put((x+1)+""+(y+1), path);
		}
		
		results.add(path);
		
		if(memory.containsKey((x)+""+(y+1)))
			path = memory.get((x)+""+(y+1));
		else{
			path = getLongestPath(x,y+1,matrix);
			memory.put((x)+""+(y+1), path);
		}
		
		results.add(path);
		
		if(memory.containsKey((x-1)+""+(y+1)))
			path = memory.get((x-1)+""+(y+1));
		else{
			path = getLongestPath(x-1,y+1,matrix);
			memory.put((x-1)+""+(y+1), path);
		}
		
		results.add(path);
		
		if(memory.containsKey((x-1)+""+(y)))
			path = memory.get((x-1)+""+(y));
		else{
			path = getLongestPath(x-1,y,matrix);
			memory.put((x-1)+""+(y), path);
		}
		
		results.add(path);
		
		return Collections.max(results)+1;
		
	}
	
}
