package com.Main.Arrays;



public class ArrayStructures {	
  public static int arraySize = 0;
  public static int[] array;
  public static ArrayStructures arrayStructures;
	public static void main(String[] args) {
	 arrayStructures  = new ArrayStructures();
	 array = arrayStructures.generateArrays(5);
	arrayStructures.displayArray();
	arrayStructures.selectionSort();
	}
	
	
	public void insertionSort() {
		for(int i = 1; i<= arraySize-1 ; i++) {
			int j = i-1;
			while( j>=0 && j<i) {
				if(array[i]< array[j]) {
					swap(i,j);
					i--;
				
				}
				j--;
			}
		}
		displayArray();
		
	}
	
	public void selectionSort() {
		for(int i = 0 ; i < arraySize-1; i++) {
			int minimum = array[i];
			for(int j = i+1 ; j< arraySize ;j++) {
				if(minimum>array[j]) {
					swap(i,j);
				}
				displayArray();
			}
		
		}	
	}
 
	public void bubbleSort() {
	
	for(int i = 0 ; i<arraySize-1; i++) {
		boolean swapped = false;
		for(int j = 0 ; j<arraySize-1-i ;j++) {
				if(array[j] > array[j+1]) {
					swap(j,j+1);
					swapped =true;
				}
			
			}
		if(!swapped) {
			break;
		}
		}

	displayArray();
	}
	
	public void swap(int first , int second) {
		int temp = array[first];
		array[first] = array[second];
		array[second] = temp; 
	}
	
	
	public void add(int ele, int idx) {
	if(idx>arraySize) {
		System.out.println("Wrong Index please update");
	}
	else if(arraySize<=10) {
			int [] newArray = new int[11];
		  for(int i = 0 ; i < arraySize ; i++) {
			  newArray[i] = array[i];
		  }
		  array = newArray;
		  arraySize++;
		}
	  for(int i = arraySize-1 ; i>idx ; i--) {
		  array[i] = array[i-1];
	  }
	  array[idx] = ele;
	  ArrayStructures arrayStructures  = new ArrayStructures();
	arrayStructures.displayArray();
	}
	
	public void delete(int ele )
	{
		ArrayStructures as = new ArrayStructures();
		if(!as.contains(ele)) {
			System.out.println("Element not present in the array");
		}
		while(as.contains(ele)) {
			int idx = as.containsAt(ele);
			for(int i = idx ; i<array.length-1 ;i++) {
				array[i] = array[i+1] ;
			}
			arraySize--;
		}
		as.displayArray();
		
	}
	
	
  public void containsAll(int ele) {
	  int i = 0;
	  if(!new ArrayStructures().contains(ele)) {
		  System.out.println("This Element is not present in the array");
	  }
	  else {
	  StringBuilder sb = new StringBuilder("This Element is present at : ");
	  while(i<arraySize) {
		  if(array[i] == ele) {
			  sb.append(i +" ");
		  }
		  i++;
	  }
	  System.out.println(sb.toString());
	  }
	  
  }
	
	
	public int containsAt(int ele ) {
		for(int i = 0 ; i < arraySize ; i++) {
			if(ele == array[i] ) {
				return i;
			}			
		}
		return -1;
	}
	
	
	public boolean contains(int ele ) {
		for(int i = 0 ; i < arraySize ; i++) {
			if(ele == array[i] ) {
				return true;
			}			
		}
		return false;
	}
		
	
	public void displayArray() {
		 System.out.println("-----------------------------------------");	
		System.out.print("| ");
		 for(int i = 0 ; i <arraySize ; i++) {
				System.out.print(  array[i] + " | ");
			}
		System.out.println();
		 System.out.println("-----------------------------------------");	
		 System.out.print("| ");
		 for(int i = 0 ; i <arraySize ; i++) {
				System.out.print(  i + " |  ");
			}
		 System.out.println();
		 System.out.println("-----------------------------------------");

		}
   	
	
  public int[] generateArrays(int size) {
	  int [] array = new int[size];
	  int m = 5;
	  for(int i = 0 ; i < array.length ; i++) {
//		  array[i] = i(int) (Math.random()*10+10);
		  array[i] = m--;
	  }
	  arraySize = array.length;
	  return array;
  }

}
