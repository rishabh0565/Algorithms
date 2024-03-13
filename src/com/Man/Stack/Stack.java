package com.Man.Stack;

import java.util.Arrays;

public class Stack {

	private int stackSize;
	private int[] stack ;
	private int topOfStack = -1;
	
	public Stack(int size) {
		stack = new int[size];
		stackSize= stack.length;
		Arrays.fill(stack, -1);
	}
	
	public void popAll() {
		for(int i = topOfStack ; i>=0 ; i--) {
			pop();
		}
	}
	
	public void multiplePush(String s) {
		 String[] split = s.split(" ");
		 for(int i = 0 ; i<split.length ; i++) {
			push(Integer.parseInt(split[i]));
			System.out.println("pushed " + i + " ");
		 }
		 displayStack();
	}
	
	public void push(int ele) {
		if(topOfStack+1 >=stackSize) {
			System.out.println("Sorry Stack is full");
		}
		else {
			topOfStack++;
			stack[topOfStack] = ele;
		}
		displayStack();
	}
	
	public void pop() {
		if(topOfStack == -1) {
			System.out.println("Sorry Stack is already Empty");
		}
		else {
			System.out.println("Popped out " + stack[topOfStack]);
			stack[topOfStack] = -1;
			topOfStack--;
		
			
		}
		displayStack();
	}

	
    private void peek() {
    	if(topOfStack==-1) {
    		System.out.println("Stack is empty");
    	}
    	else {
    		System.out.println(stack[topOfStack]);
    	}
    }
	private void displayStack() {
		System.out.println("-----------------------------------------");	
		System.out.print("| ");
		 for(int i = 0 ; i <stackSize ; i++) {
			 if(stack[i]!=-1) {
				System.out.print(  stack[i] + " | ");
			 }
			 else {
				 System.out.print( "  "+ " | ");
			 }
			}
		System.out.println();
		 System.out.println("-----------------------------------------");	
		 System.out.print("| ");
		 for(int i = 0 ; i <stackSize ; i++) {
				System.out.print(  i + " |  ");
			}
		 System.out.println();
		 System.out.println("-----------------------------------------");

	}
	
	public static void main(String[] args) {
		Stack s = new Stack(10);
		s.displayStack();
		s.push(5);
		s.push(8);
		s.push(7);
		s.pop();
		s.multiplePush("45 31 7");
		s.pop();
		s.popAll();
		s.peek();


	}
	
	

}
