package com.Main.Recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayRecurssion {

	public static void main(String[] args) {
  	//	System.out.println(Arrays.toString( sortArray(new int[] {1,4,3,1,54,2}, 0, 0)));
  		//System.out.println(isSorted(new int[] {1,4,3,1,54,2},0));
	int [] arr = new int[] { 90,76,5,4,6,18,91, 93};
	//	System.out.println(isSorted(new int[] {1,2,3,4,4},0));
System.out.println(rotatedBinarySearch(arr, 90, 0,arr.length-1));
	}
	
// finding number in rotated binary search
	
	public static int rotatedBinarySearch(int[] arr, int ele, int start, int end) {
		if(start>end) {
			return -1;
		}
		int mid = (start+end)/2;
		if(arr[start] == arr[mid]) {
			return mid;
		}
		if(arr[mid]<=arr[start]) {
			if(ele<=arr[mid] && ele>=arr[start]) {
		return rotatedBinarySearch(arr, ele, start, mid-1);
			}
			else {
				return rotatedBinarySearch(arr, ele, mid+1, end);
			}
		}
		
	
			if(ele>=arr[mid] && ele<=arr[end]) {
		return rotatedBinarySearch(arr, ele, mid+1, end);
			}
			else {
				return rotatedBinarySearch(arr, ele, start, mid-1);
			}
		
	}
	
	
//	returning  all indexes without using arraylist in argument 
	public static ArrayList<Integer> allIndexesWithoutListInArg(int [] arr, int ele, int start) {
		ArrayList<Integer> indexes  = new ArrayList<Integer>();
		if(start==arr.length) {
			return indexes;
		}
		if(arr[start] == ele) {
			indexes.add(start);
		}
		 ArrayList<Integer> ans = allIndexesWithoutListInArg(arr, ele, ++start);
	   indexes.addAll(ans);
	   return indexes;
	}
	
	
	
	// returning all indexes for element
	public static ArrayList<Integer> allIndexes(int [] arr, ArrayList<Integer> indexes, int ele, int start) {
		if(start==arr.length) {
			return indexes;
		}
		if(arr[start] == ele) {
			indexes.add(start);
		}
		return allIndexes(arr, indexes, ele, ++start);
	}
	
	//linear search
   public static boolean linearSearch(int [] arr , int ele, int start) {
	   if(start==arr.length) {
		   return false;
	   }
	  
	   return arr[start] == ele || linearSearch(arr, ele, ++start);
   }
	
	
// is array sorted 
	
  public static boolean isSorted(int[] arr , int size) {
	  if(size+1>=arr.length) {
		  return true;
	  }
	  if(arr[size] > arr[size+1]) {
		  return false;
	  }
	  return isSorted(arr, ++size);
	 
  }
	
// sorting array 
  public static int [] sortArray(int [] array, int size, int itr) {
	  if(size+1==array.length) {
		 itr++;
		 size=0;
		 if(itr>=array.length) {
			 return array;
		 }
	  }
	  if(array[size+1]<array[size]) {
		  swap(array, size, size+1);
		  System.out.println(Arrays.toString(array));
	  }
	  return sortArray(array, ++size,itr);
	  
  }
  public static void swap (int[] swap , int start , int end) {
	  int temp = swap[start];
	  swap[start] = swap[end];
	  swap[end] = temp;
  }
}
