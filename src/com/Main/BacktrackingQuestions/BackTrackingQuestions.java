package com.Main.BacktrackingQuestions;

public class BackTrackingQuestions {

	public static void main(String[] args) {
		int n = 4;
		boolean [][] board = new boolean[n][n];
//		display(board);
//System.out.println(queenPlacement(board, 0));
kingPlacement(board, 0, 0,4);
	}
	
	public static void  kingPlacement(boolean [][] board, int rows, int cols,int max) {
	    if(max == 0) {
	    	displayKingBoard(board);
	    	System.out.println();
	    	return;
	    }	    
	    if(cols == board[0].length-1 && rows == board.length-1) {
	    	return;    		
	    }  
	    if(cols == board[0].length) {	        
	    	kingPlacement(board, rows+1, 0 , max);
		    return;
		    }
	    if( isSafeToPlaceKing(board, rows, cols)) {
	    	board[rows][cols] = true;
	    	kingPlacement(board, rows, cols+1,max-1);
	    	board[rows][cols] = false;
	    }
	    kingPlacement(board, rows, cols+1 , max);
 
	}
	
	private static boolean isSafeToPlaceKing(boolean[][] board, int rows, int cols) {
	     if(isValidForKing(board, rows, cols-1)) {
	    	 if(board[rows][cols-1]) {
	    		 return false;
	    	 }
	     }
	     if(isValidForKing(board, rows, cols+1)) {
	    	 if(board[rows][cols+1]) {
	    		 return false;
	    	 }
	     }
	     if(isValidForKing(board, rows-1, cols)) {
	    	 if(board[rows-1][cols]) {
	    		 return false;
	    	 }
	     }
	     
	     if(isValidForKing(board, rows-1, cols+1)) {
	    	 if(board[rows-1][cols+1]) {
	    		 return false;
	    	 }
	     }
	     if(isValidForKing(board, rows-1, cols-1)) {
	    	 if(board[rows-1][cols-1]) {
	    		 return false;
	    	 }
	     }
		return true;
	}




	private static boolean isValidForKing(boolean[][] board, int rows, int cols) {
		if(rows<board.length && rows>=0&& cols<board[0].length &&cols>=0) {
			return true;
		}
	
		return false;
	}




	private static void displayKingBoard(boolean[][] board) {
		   for(boolean [] arrr : board) {
			   for(int i = 0 ; i < arrr.length ; i++) {
				   if(arrr[i] == false) {
					   System.out.print(". ");
				   }
				   else {
					   System.out.print("K ");
				   }
			   }
			   System.out.println();
		   }
		}
	
	
	
	
	/////////////////////////////////////////////////////
	public static void  knightPlacement(boolean [][] board, int rows, int cols,int max) {
	    if(max == 0) {
	    	displayKnightBoard(board);
	    	System.out.println();
	    	return;
	    }	    
	    if(cols == board[0].length-1 && rows == board.length-1) {
	    	return;    		
	    }  
	    if(cols == board[0].length) {	        
		    knightPlacement(board, rows+1, 0 , max);
		    return;
		    }
	    if( isSafeToPlaceKnight(board, rows, cols)) {
	    	board[rows][cols] = true;
	    	knightPlacement(board, rows, cols+1,max-1);
	    	board[rows][cols] = false;
	    }
      knightPlacement(board, rows, cols+1 , max);
 
	}
	
	private static boolean isSafeToPlaceKnight(boolean[][] board, int rows, int cols) {
	     if(isValid(board, rows-1, cols-2)) {
	    	 if(board[rows-1][cols-2]) {
	    		 return false;
	    	 }
	     }
	     if(isValid(board, rows-1, cols+2)) {
	    	 if(board[rows-1][cols+2]) {
	    		 return false;
	    	 }
	     }
	     
	     if(isValid(board, rows-2, cols-1)) {
	    	 if(board[rows-2][cols-1]) {
	    		 return false;
	    	 }
	     }
	     if(isValid(board, rows-2, cols+1)) {
	    	 if(board[rows-2][cols+1]) {
	    		 return false;
	    	 }
	     }
		return true;
	}




	private static boolean isValid(boolean[][] board, int rows, int cols) {
		if(rows<board.length && rows>=0&& cols<board[0].length &&cols>=0) {
			return true;
		}
	
		return false;
	}




	private static void displayKnightBoard(boolean[][] board) {
		   for(boolean [] arrr : board) {
			   for(int i = 0 ; i < arrr.length ; i++) {
				   if(arrr[i] == false) {
					   System.out.print(". ");
				   }
				   else {
					   System.out.print("K ");
				   }
			   }
			   System.out.println();
		   }
		}
	
	
	
/////////////////////////////////////////////////////////////////////////	
	
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
