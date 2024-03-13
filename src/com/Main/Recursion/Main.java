package com.Main.Recursion;

import java.util.Arrays;
import java.util.Random;
import java.util.random.RandomGenerator;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(fabonacci(4));
		System.out.println(binarySearch(7, new int[] {1,2,3,4,5} , 0 , 4));

	}
	
	public static int binarySearch(int ele, int [] arr, int start , int end) {
		if(start>end) {
			return -1;
		}
		int middle = (start + end)/2;
	if(arr[middle] == ele ) {
		return middle;
	}
	if(arr[middle] < ele) {
		start = middle+1;
	}
	if(arr[middle] > ele) {
		end = middle-1;
	}
	return binarySearch(ele, arr, start, end);
		
	}
	
	public static int fabonacci( int size) {
		if(size<2) {
			return size;
		}
		
		return fabonacci(size-1) + fabonacci(size-2);
	}

}
