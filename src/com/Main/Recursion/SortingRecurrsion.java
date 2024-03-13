package com.Main.Recursion;

import java.util.Arrays;

public class SortingRecurrsion {

	public static void main(String[] args) {
//	    mergeSortInPlace(arr,0,5);
//	   System.out.println(Arrays.toString(arr));
	   int [] ar = new int[] {456,6,98,07,12,55};
	   mergeSortInPlace(ar, 0, ar.length);
	   System.out.println(Arrays.toString(ar));
	   

	}
	
	
	// Merge Sort using the same array and sorting it at a same place
	public static void  mergeSortInPlace(int[] arr , int start, int end) {
		if(end-start == 1) {
			return ; 
		}
		int mid = (start+end)/2;
		mergeSortInPlace(arr, start ,mid);
		mergeSortInPlace(arr, mid ,end);
		mergeArraysInPlace(arr,start ,mid, end);
	}
	
	public static void mergeArraysInPlace(int[] arr, int start , int mid, int end) {
       int [] mix = new int[end-start];		
		int i  = start; 
		int j= mid ; 
		int  k = 0;
		while(i<mid && j<end) {
			if(arr[i] < arr[j]) {
				mix[k] = arr[i++];			
			}
			else {
			mix[k] = arr[j++];}
			k++;
		}
		while(i<mid) {
			mix[k] = arr[i++];
			k++;
		}
		while(j<end) {
			mix[k] = arr[j++];
			k++;
		}
		arr = mix;
	}
	
	
	
	
	// Merge Sort using copy Of Array. No updating passed array.
	
	public static int [] mergeSort(int[] arr) {
		if(arr.length == 1) {
			return arr;
		}
		int mid = arr.length/2;
		int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
		int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));
		return mergeArrays(left,right);
	}
	
	public static int[] mergeArrays(int[] left, int[] right) {
		int [] mix = new int[left.length+right.length];
		int i  = 0 ; 
		int j= 0 ; 
		int  k = 0;
		while(i<left.length && j<right.length) {
			if(left[i] > right[j]) {
				mix[k] = right[j++];			
			}
			else {
			mix[k] = left[i++];}
			k++;
		}
		while(i<left.length) {
			mix[k] = left[i++];
			k++;
		}
		while(j<right.length) {
			mix[k] = right[j++];
			k++;
		}
		return mix;
	}

}
