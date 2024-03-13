package com.Main.Recursion;

public class PatternRecussion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		patternUsingRecurssion1(3,0);

	}
	
	
	public static void patternUsingRecurssion1(int row , int col) {
		if(row == 0) {
			return;
		}
		if(++col<=row) {
			System.out.print("* ");
			patternUsingRecurssion1(row, col++);
		}
		if(col == row) {
			System.out.println();
            patternUsingRecurssion1(--row, 0);			
		}
	}
	

	
	
	
	
	
    // *
	// **
	// ***
	public static void patternUsingRecurssion2(int row , int col) {
		if(row==0) {
			return;
		}
		
	    if(col>row) {
	    	 System.out.println();
	    	patternUsingRecurssion2(--row, --col);
	    }
	    if(col<=row) {
	    	System.out.print("*" + " ");
	    	patternUsingRecurssion2(row, ++col);
	    }
	  
	}	

// ***
// **
// *
public static void patternUsingRecurssion(int row , int col) {
	if(row==0) {
		return;
	}
	
    if(++col<=row) {
    	 System.out.print("*"+ " ");
    	patternUsingRecurssion(row, col++);
    }
    if(row==col) {
    	System.out.println();
    	patternUsingRecurssion(--row, 0);
    }
  
}	


}
