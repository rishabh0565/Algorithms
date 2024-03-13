package com.Main.Arrays;


import java.util.ArrayList;
import java.util.List;

public class test {

	public static void main(String[] args) {
	
	//System.out.println(numbers("" , "23456789"));
	//System.out.println(numberPad("", "6579"));
	printDiceNumbersForTargetSum("", 80);
	}
	
	
	public static void printDiceNumbersForTargetSum(String ans, int target) {
		if(target == 0 ) {
			System.out.println(ans);
			return;
		}
		for(int i = 1 ; i <=6 && i<=target; i++) {
			printDiceNumbersForTargetSum(ans+i, target-i);
		}
	}

	public static List<String> numberPad(String left , String right) {
		if(right.isEmpty()) {
			List <String> ans = new ArrayList<String>();
			ans.add(left);
			return ans;
		}
	
		int digit = right.charAt(0) -  '0';
		
		List <String> arrayCombination = new ArrayList<String>();
		if(digit!=1 && digit!=0) {
		if(digit==7 || digit == 9) {
			int start = digit==7?15:22;
			for(int i = start ; i< start+4  ; i++) {
				char c = (char) ('a'  + i) ; 
				arrayCombination.addAll( numberPad(left+c, right.substring(1)));
			}
		}
		else {
		for(int i = (digit-2)*3 ; i<(digit*3 -3) ; i++) { 
			char c  = (char)('a' + i);
			arrayCombination.addAll( numberPad(left+c, right.substring(1)));		
		}
		}
		
		}
		return arrayCombination;
		
		
	}
	
	
	public static List<String> numbers(String left, String right) {
	    if(right.isEmpty()) {
	     ArrayList<String> arrayList = new ArrayList<String>() ;
	     arrayList.add(left);
	     return arrayList;
	    }
	    ArrayList<String> arrayList = new ArrayList<String>() ;
	    int n = left.length();
	    for(int i = 0 ; i <= n ; i++) {
	    	String front = left.substring(0,i);
	    	String ch = "" + right.charAt(0);
	    	String rear = left.substring(i,n);
	    	arrayList.addAll( numbers(front+ ch + rear, right.substring(1)));
	    }
	    return arrayList;
	    
	}
	
	
}


