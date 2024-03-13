package com.Main.BacktrackingQuestions;

public class BackTrackingQuestions {

	public static void main(String[] args) {
		int n = 4;
		boolean [][] board = new boolean[n][n];
//		display(board);
System.out.println(queenPlacement(board, 0));
	}
	
	
	
	
	public static int queenPlacement(boolean[][] board, int rows) {
		if(rows == board.length) {
			display(board);
			System.out.println();
			return 1;
		}
		int count = 0;
		for(int col = 0 ;  col < board[0].length ; col++) {
			if(isSafe(board, rows, col)) {
				board[rows][col] = true;
				count+=queenPlacement(board, rows+1);
				board[rows][col] = false;
			}
		}
		return count;
	}

	private static boolean isSafe(boolean[][] board, int rows, int col) {
	   
		//vertcal column check for queen
		for(int i = 0 ; i<rows ; i++) {
	    	  if(board[i][col]) {
	    		  return false;
	    	  }
	      }
	      //left diagonal check for queen by taking  minimum of row, col. 
		int leftRange = Math.min(rows, col);
		for(int i = 1 ; i<=leftRange  ;i++ ) {
			if(board[rows-1][col-1]) {
				return false;
			}
		}
		// right diagonal check 
		int rightRange = Math.min(rows, board.length-1-col);
		for(int i = 1 ; i<=rightRange  ;i++ ) {
			if(board[rows-i][col+i]) {
				return false;
			}
		}
		return true;
		
	}

	private static void display(boolean[][] board) {
	   for(boolean [] arrr : board) {
		   for(int i = 0 ; i < arrr.length ; i++) {
			   if(arrr[i] == false) {
				   System.out.print("* ");
			   }
			   else {
				   System.out.print("Q ");
			   }
		   }
		   System.out.println();
	   }
	}

}
