package com.Main.LinkedList;

public class Linkedlist {
    private node[] linkedlist;
    private  int linkedListSize;
    private int noOfNodes;
	public Linkedlist(int size) {
		linkedlist = new node[size];
		linkedListSize = linkedlist.length;
		noOfNodes =-1;
	}
	
	
	public static void main(String args[]) {
       		Linkedlist ll = new Linkedlist(6);
       		ll.displayLinkedList();
       	
	}
	
	public void deleteNode(int ele) {
		int idx= containsAt(ele);
		if(idx==-1) {
			System.out.println("Element is not present in linkedList");
		}
		else {
			System.out.println(ele + " is deleted from linkedlist");
			for(int i = idx; i<linkedListSize-1 ;i++) {
				shiftNode(i, i+1);
			}
	
		linkedlist[noOfNodes] = null;
		noOfNodes--;
		displayLinkedList();
		}
	}
	
	public void addNode(int ele) {
		if(noOfNodes ==-1) {
			noOfNodes++;
			node firstnode = new node();
			firstnode.setValue(ele);
			firstnode.setNext(null);
			linkedlist[noOfNodes] =firstnode ;		
		}
		else if(noOfNodes+1>linkedListSize-1) {
			System.out.println("Linked list is already full");
		}
		else {
			System.out.println(ele + " is added in linkedList");
			node link = new node();
			linkedlist[noOfNodes].setNext(link);		
			link.setValue(ele);
			link.setNext(null);
			noOfNodes++;		
			linkedlist[noOfNodes]= link;
		}
		displayLinkedList();
	}
	
	public void shiftNode(int i, int j) {
		linkedlist[i] = linkedlist[j];
		
		
	}
	
	public int containsAt(int ele) {
		for(int i = 0 ; i<=noOfNodes ; i++) {
			if(ele == linkedlist[i].getValue()) {
				return i;
			}
			
		}
		return -1;
	}
	
	public void displayLinkedList() {
		if(linkedlist[0] == null) {
			System.out.println("Linked list is empty");
		}
		else {
			System.out.println("-----------------------------------------");	
			System.out.print("| ");
			for(int i = 0 ; i<linkedListSize ; i++) {
			
				if(linkedlist[i] != null) {
							System.out.print( linkedlist[i].getValue() + " | ");
						 }
						 else {
							 System.out.print( "  "+ " | ");
						 }
						}
					System.out.println();
					 System.out.println("-----------------------------------------");	
					 System.out.print("| ");
					 for(int i = 0 ; i <linkedListSize ; i++) {
							System.out.print(  i + " |  ");
						}
					 System.out.println();
					 System.out.println("-----------------------------------------");
				}
			}

	public class node{
		private int value; 
		private node next ;
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
		public node getNext() {
			return next;
		}
		public void setNext(node next) {
			this.next = next;
		}
		
	}
	}
	



