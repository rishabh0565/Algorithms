package com.Main.Recursion;

public class Questions {

	public static void main(String[] args) {
	//	printUptoNo(100);
//		System.out.println(sumUptoN(5));
		System.out.println(countStepsToZero(14,0));

	}
	
	//leetcode 1342  count steps tommake number to zero, when even divide by 2 or if odd subtract by 1
	
	public static int countStepsToZero(int no, int count) {
		if(no==0) {
			return count;
		}
		if(no%2==0) {
			return countStepsToZero(no/2, ++count);
		}
		else {
		  return	countStepsToZero(no-1, ++count);
		}
	}
	
	// counting zeros in number
	
	public static int findZeros(int no, int count) {
		if(no<=0) {
			return count;
		}
		if(no%10 == 0) {
			count++;
		}
		return findZeros(no/10, count );
	}
	
	
	//check for palindrome string
	public static boolean palindrome(String s, int start, int end) {
		if(start>end) {
			return true;
		}
		if(s.charAt(start)!=s.charAt(end)) {
			return false;
		}
		return palindrome(s, ++start, --end);
		
	}
	
	
	// reverse a number
	
	public static int reverseNumber(int no, int rev) {
		if(no<=0) {
			return rev;
		}
		rev*=10;
		rev+=no%10;
		
		return reverseNumber(no/10,rev);
		
	}
	
	
	
	// print  1- to N
	public static void  printUptoNo(int no) {
		 if(no<1) {  
	    	   return;
	       }
		printUptoNo(no-1);
      
       System.out.print(no + " ");
        
	}
	//factorial of N
	public static int factorial(int no) {
		if(no<1) {return 1;}

			 System.out.print(no +" * ");
		
		 return  no*factorial(no-1);
		
	}
	
	//sum of N
		public static int sumUptoN(int no) {
			if(no<1) {return 0;}

				 System.out.print(no +" + ");
			
			 return  no+sumUptoN(no-1);
			
		}
		
		// sum of digits
		
		public static int sumOfDigits(int no) {
			if(no<=0) {
				return 0;
			}
			
			return no%10+sumOfDigits(no/10);
			
		}

}
