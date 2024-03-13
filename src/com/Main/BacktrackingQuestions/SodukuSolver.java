package com.Main.BacktrackingQuestions;


import java.util.Arrays;

public class SodukuSolver {

	public static void main(String[] args) {
		
	int[][]  sudoku = {
//			{3,0,6,5,0,8,4,0,0},
//			{5,2,0,0,0,0,0,0,0},
//			{0,8,7,0,0,0,0,3,1},
//			{0,0,3,0,1,0,0,8,0},
//			{9,0,0,8,6,3,0,0,5},
//			{0,5,0,0,9,0,6,0,0},
//			{1,3,0,0,0,0,2,5,0},
//			{0,0,0,0,0,0,0,7,4},
//			{0,0,5,2,0,6,3,0,0},
			{3, 0, 6, 5, 2, 8, 4, 9, 7},			
					{5, 0, 1, 4, 3, 7, 8, 6, 9},
					{2, 8, 7, 6, 4, 9, 5, 3, 1},
					{6, 4, 3, 9, 1, 5, 7, 8, 2},
					{9, 7, 4, 8, 6, 3, 1, 2, 5},
					{7, 5, 8, 1, 9, 2, 0, 4, 3},
					{1, 3, 9, 7, 8, 4, 2, 5, 6},
					{8, 6, 2, 3, 5, 1, 9, 7, 4},
					{4, 9, 5, 2, 7, 6, 3, 1, 8}
			
	};	
	if(solveSudoku(sudoku)) {
		displaySudoku(sudoku);
	}
	else {
		System.out.println("Cannot be solved");
	}
	
       
	}
	
public static boolean solveSudoku(int [][] sudoku) {
	int n = sudoku.length;
	int row = -1;
	 int col = -1;
	 
	 boolean isEmptyNumber = false;
	for(int i = 0 ; i< n ; i++) {
		for(int j = 0 ; j < n; j++) {
			//when at any place empty number is found 
			//we will break the loop and try adding the number
			if(sudoku[i][j] == 0) {
			 row = i ;
			 col = j ;
			 isEmptyNumber = true;
			 break;
			}
		}
		if(isEmptyNumber) {
			break;
		}		
	}
	//sudoku is solved as there was no empty number found in it
	if(isEmptyNumber == false) {
		return true;
	}
	
	// trying adding the number to each empty space
	for(int number = 1; number<=9 ; number++) {
		// checking whether at given point we can add the number by checking that row and coloum and the box
		if(isSafe(sudoku, row, col,number)) {
			sudoku[row][col] = number;
			// if previus call return true that ,mean sudokuu is solved;
			if(solveSudoku(sudoku)) {
				return true;
			}
			//backtracting is also done if the previous call return false value
			else {
				sudoku[row][col] = 0;
			}
		}
	}	
	
	// sudoku cant be solved
	return false;
}

private static boolean isSafe(int[][] sudoku, int row, int col, int number) {
	
	
	//entire row search for number
	for(int i = 0 ; i < sudoku.length ; i++) {
		if(sudoku[row][i] == number) {
			return false;
		}
	}
	//entire col search for number
	for(int i = 0 ; i < sudoku.length ; i++) {
		if(sudoku[i][col] == number) {
			return false;
		}
	}
	
	 // entire box checked for that number
	int sqrt =(int) Math.sqrt(sudoku.length);
	int startRowForBoxIndex = row - row%sqrt;
	int startColForBoxIndex = col - col%sqrt;
	for(int i = startRowForBoxIndex ; i<startColForBoxIndex+sqrt ; i++) {
		for(int j = startColForBoxIndex ; j<startColForBoxIndex+sqrt; j++) {
			if(sudoku[startRowForBoxIndex][startColForBoxIndex] == number) {
				return false;
			}
		}
	}
	return true;
}

public static void displaySudoku(int[][] sudoku) {
	for(int[] arr: sudoku) {
		System.out.println(Arrays.toString(arr));
	}
	
}
	

}
