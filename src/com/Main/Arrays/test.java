package com.Main.Arrays;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test {

	public static void main(String[] args) {
	
	boolean [][] maze = {
			{true, true, true},
			{true, true, true},
			{true, true, true},
	};
	String [][] steps = new String[maze.length][maze[0].length];
	for(String[] arr: steps) {
	  for(int i = 0 ; i < arr.length ; i++) {
		  arr[i] = ".";
	  }
	}
	printMazeWithStepsInAllDirections(maze,"",0,0 ,steps, "*");
			}
	
	
	
	
	static void printMazeWithStepsInAllDirections(boolean[][] maze,String path, int row, int col, String[][] steps, String count) {
		if(row==maze.length-1 && col==maze[0].length-1) {
			steps[row][col] = count;
			for(String[] arr : steps) {
				System.out.println(Arrays.toString(arr));
			}
			System.out.println(path);			
			return;
		}
		
		if(!maze[row][col]) {
			return;
		}
		steps[row][col] = count;
		maze[row][col] = false;

		if(row<maze.length-1) {
			printMazeWithStepsInAllDirections(maze, path+'D', row+1, col, steps, "🡣"
					+ "");
		}
		if(col<maze[0].length-1 && row<maze.length-1) {
			printMazeWithStepsInAllDirections(maze, path+'X', row+1, col+1, steps, "🡮");
		}
	
		if(col<maze[0].length-1) {
			printMazeWithStepsInAllDirections(maze, path+'R', row, col+1, steps, "🡢");
		}
		if(col>0) {
			printMazeWithStepsInAllDirections(maze, path+'L', row, col-1, steps, "←");
		}
		if(row>0) {
			printMazeWithStepsInAllDirections(maze, path+'U', row-1, col, steps, "🡡");
		}
		
		steps[row][col] = ".";
		maze[row][col] = false;
		
	}
	
	static void printDiceNumberForGivenNumber(String ans , int target) {
		if(target == 0) {
			System.out.println(ans);
			return;
		}
		for(int i = 1; i <=6 && i<=target ; i++) {
			printDiceNumberForGivenNumber(ans+i, target-i);
		}
		
	}

	public static List<String> numberPad(String left , String right) {
		if(right.isEmpty()) {
			List <String> ans = new ArrayList<String>();
			ans.add(left);
			return ans;
		}
	
		int digit = right.charAt(0) -  '0';
		
		List <String> arrayCombination = new ArrayList<String>();
		if(digit!=1 && digit!=0) {
		if(digit==7 || digit == 9) {
			int start = digit==7?15:22;
			for(int i = start ; i< start+4  ; i++) {
				char c = (char) ('a'  + i) ; 
				arrayCombination.addAll( numberPad(left+c, right.substring(1)));
			}
		}
		else {
		for(int i = (digit-2)*3 ; i<(digit*3 -3) ; i++) { 
			char c  = (char)('a' + i);
			arrayCombination.addAll( numberPad(left+c, right.substring(1)));		
		}
		}
		
		}
		return arrayCombination;
		
		
	}
	
	
	public static List<String> numbers(String left, String right) {
	    if(right.isEmpty()) {
	     ArrayList<String> arrayList = new ArrayList<String>() ;
	     arrayList.add(left);
	     return arrayList;
	    }
	    ArrayList<String> arrayList = new ArrayList<String>() ;
	    int n = left.length();
	    for(int i = 0 ; i <= n ; i++) {
	    	String front = left.substring(0,i);
	    	String ch = "" + right.charAt(0);
	    	String rear = left.substring(i,n);
	    	arrayList.addAll( numbers(front+ ch + rear, right.substring(1)));
	    }
	    return arrayList;
	    
	}
	
	
}


