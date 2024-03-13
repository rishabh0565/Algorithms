package com.Main.Recursion;

import java.util.ArrayList;
import java.util.List;

public class QuestionsRecusionIMP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder("");
 //   System.out.println(removeAs("Rishabh",0));
   //printSubset("", "abcd");
    
    System.out.println(printSubsetWithArrayListNoArgs("", "abc"));
    iterativeWayForSubSet("abc");
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
	
	
	public static void numberPad(String left , String right) {
		if(right.isEmpty()) {
			System.out.println(left);
			return;
		}
		int digit = right.charAt(0) -  '0';
		for(int i = (digit-1)*3 ; i<(digit*3) ; i++) { 
			char c  = (char)('a' + i);
			numberPad(left+c, right.substring(1));		
		}
		
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
	
	
public static void iterativeWayForSubSet(String str) {
	List<List<String>> outer = new ArrayList<List<String>>();
    outer.add(new ArrayList<String>());
    for(int i = 0 ; i < str.length() ; i++) {
    	 int n = outer.size();
    	 for(int j = 0 ; j< n ; j++) {
    		 List<String> inner = new ArrayList<String>(outer.get(j));
            inner.add("" + str.charAt(i));
            outer.add(inner);
    	 }
    }
    System.out.println(outer);
}
	
	

	// printSubset of possible in string and return in ArrayList without adding new args
	private static ArrayList<String> printSubsetWithArrayListNoArgs(String left , String right) {
		ArrayList<String> ans = new ArrayList<String>();
		if(right.isEmpty()) {
			ArrayList<String> array = new ArrayList<String>(); 
			array.add(left);
			return array;
		}
		
		ans.addAll( printSubsetWithArrayListNoArgs(left+ right.charAt(0), right.substring(1)));
		ans.addAll( printSubsetWithArrayListNoArgs(left,right.substring(1)));
		//ans.addAll(printSubsetWithArrayListNoArgs( left + (right.charAt(0)+0), right.substring(1)));
		
		return ans;
	}	
	
	
	
	// printSubset of possible in string
	private static void printSubset(String left , String right) {
		if(right.isEmpty()) {
			System.out.println(left);
			return;
		}
		
		printSubset(left+ right.charAt(0), right.substring(1));
		printSubset(left,right.substring(1));
	}
	
	
	
	//remove A from String using recursion
	private static String removeAs(String string,int i) {
		String ans = "";
		if(i==string.length()) {
			return ans;
		}
		
		
		if(!(string.charAt(i) == 'a' )&& !(string.charAt(i) == 'A') ) {
			ans = "" + string.charAt(i);
			return removeAs(string, ++i)+ans;
			
		}
	     return  removeAs(string, ++i)+ans;
		
		
	}


	
	
	
	
	
}
