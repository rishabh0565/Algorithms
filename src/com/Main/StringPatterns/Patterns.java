package com.Main.StringPatterns;

public class Patterns {

	public static void main(String[] args) {
		//patternUsingRecurssion2(5,5);

	}
	


	// ***
	//  **
	//   *
	public static void pattern4(int n) {
		
		for(int i = 0 ; i < n ; i++) {
			
			for(int k = 0 ; k<i ; k++) {
				System.out.print("  ");
			}
			for(int  j = n ; j > i  ; j--) {
				System.out.print("*" + " ");
			}
			
				for(int  j = n ; j > i  ; j--) {
					System.out.print("*" + " ");
				}
			
			
			
			System.out.println();
		}
	}		
	
	// ***
	// **
	// *
	public static void pattern3(int n) {
		for(int i = 0 ; i < n ; i++) {
			for(int  j = n ; j > i  ; j--) {
				System.out.print("*" + " ");
			}
			System.out.println();
		}
	}	
	
	// *
	// **
	// ***
	public static void pattern2(int n) {
		for(int i = 0 ; i < n ; i++) {
			for(int  j = 0 ; j < i+1  ; j++) {
				System.out.print("*" + " ");
			}
			System.out.println();
		}
	}
	
	
// ******
// ******
// ******
public static void pattern1(int n) {
	for(int i = 0 ; i < n ; i++) {
		for(int  j = 0 ; j < n  ; j++) {
			System.out.print("*" + " ");
		}
		System.out.println();
	}
}




}
