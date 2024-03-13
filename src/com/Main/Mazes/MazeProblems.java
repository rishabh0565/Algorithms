package com.Main.Mazes;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MazeProblems {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  boolean [][] maze = {
				   {true, true, true},
				   {true, true, true},
				   {true, true, true}
		   };
		  int [][] steps = new int[maze.length][maze[0].length];
 //  System.out.println(countPathsInMaze(maze, 0, 0));
 //returnPathsInMaze(maze, 0 , 0 , "");
 //returnPathsInMazeIncludingDiagonal(maze,0,0,"");
 //returnPathsInMazeIncludingDiagonalAndAllDirection(maze,0,0,"");
 printStepsForPathInMazeIncludingDiagonalAndAllDirection(maze,0,0,"",steps , 1);

	}
//	print the 2d matrix with steps taken to reach the destination
	//simple maze problem to print number of paths with obstrical including Diagonal up and left as well 
	
		public static void printStepsForPathInMazeIncludingDiagonalAndAllDirection(boolean [][] maze, int row , int col,String paths,int[][] steps, int countStep) {
			if(row == maze.length-1 && col == maze[0].length-1) {	
				steps[row][col] = countStep;
				for(int[] arr : steps) {
					System.out.println(Arrays.toString(arr));
				}
				System.out.println(paths);
				return ;			
			}
			if(!maze[row][col]) {
				return;
			}
			  maze[row][col] = false;
			  steps[row][col] = countStep;
			if(row<maze.length-1 && col<maze[0].length-1) {
				printStepsForPathInMazeIncludingDiagonalAndAllDirection(maze,row+1, col+1,paths+"M", steps,countStep+1);
			
			  }
			
		  if(row<maze.length-1) {
			  printStepsForPathInMazeIncludingDiagonalAndAllDirection(maze,row+1, col,paths+"D", steps,countStep+1);
			
		  }
		  if(row>0) {
			  printStepsForPathInMazeIncludingDiagonalAndAllDirection(maze,row-1, col, paths+"U", steps,countStep+1);
		
		  }
		  if(col<0) {
			  printStepsForPathInMazeIncludingDiagonalAndAllDirection(maze,row, col-1, paths+"L", steps,countStep+1);
			
		  }
		  if(col<maze[0].length-1) {
			  printStepsForPathInMazeIncludingDiagonalAndAllDirection(maze,row, col+1, paths+"R", steps,countStep+1);
			  
		  }
		maze[row][col] = true;
		steps[row][col] = 0;
		}

	
	
	//simple maze problem to print number of paths with obstrical including Diagonal up and left as well 
	
	public static void returnPathsInMazeIncludingDiagonalAndAllDirection(boolean [][] maze, int row , int col,String paths) {
		if(row == maze.length-1 && col == maze[0].length-1) {
			System.out.println(paths);
			return ;
			
		}
		if(!maze[row][col]) {
			return;
		}
		  maze[row][col] = false;
		if(row<maze.length-1 && col<maze[0].length-1) {
			returnPathsInMazeIncludingDiagonalAndAllDirection(maze,row+1, col+1,paths+"M");
		
		  }
		
	  if(row<maze.length-1) {
		  returnPathsInMazeIncludingDiagonalAndAllDirection(maze,row+1, col,paths+"D");
		
	  }
	  if(row>0) {
		  returnPathsInMazeIncludingDiagonalAndAllDirection(maze,row-1, col, paths+"U");
	
	  }
	  if(col<0) {
		  returnPathsInMazeIncludingDiagonalAndAllDirection(maze,row, col-1, paths+"L");
		
	  }
	  if(col<maze[0].length-1) {
		  returnPathsInMazeIncludingDiagonalAndAllDirection(maze,row, col+1, paths+"R");
		  
	  }
	maze[row][col] = true;
	}

	
	
	
	//simple maze problem to print number of paths with obstrical including Diagonal
			public static void returnPathsInMazeIncludingDiagonal(boolean [][] maze, int row , int col,String paths) {
				if(row == maze.length-1 && col == maze[0].length-1) {
					System.out.println(paths);
					return ;
					
				}
				if(!maze[row][col]) {
					return;
				}
				if(row<maze.length-1 && col<maze[0].length-1) {
					  returnPathsInMazeIncludingDiagonal(maze,row+1, col+1,paths+"M");
				  }
			  if(row<maze.length-1) {
				  returnPathsInMazeIncludingDiagonal(maze,row+1, col,paths+"D");
			  }
			  if(col<maze[0].length-1) {
				  returnPathsInMazeIncludingDiagonal(maze,row, col+1, paths+"R");
			  }
			
			}
	
		
	
	
	//simple maze problem to print number of paths with obstrical
		public static void returnPathsInMaze(boolean [][] maze, int row , int col,String paths) {
			if(row == maze.length-1 && col == maze[0].length-1) {
				System.out.println(paths);
				return ;
				
			}
			if(!maze[row][col]) {
				return;
			}
		  if(row<maze.length-1) {
		 returnPathsInMaze(maze,row+1, col,paths+"D");
		  }
		  if(col<maze[0].length-1) {
		 returnPathsInMaze(maze,row, col+1, paths+"R");
		  }
		
		}
	
	
	//simple maze problem to print number of paths with obstrical
	public static int countPathsInMaze(boolean [][] maze, int row , int col) {
		if(row == maze.length-1 || col == maze.length-1) {
			return 1;
		}
		int count  =0 ;
		if(!maze[row][col]) {
			return 0;
		}
		count += countPathsInMaze(maze,row+1, col);
		count += countPathsInMaze(maze,row, col+1);
		return count;
	}

}
