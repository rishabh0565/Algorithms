package com.Man.Queue;

public class Queue {
  
	private int [] queue;
	private int queueSize;
	private int front;
	private int rear;
	public Queue(int size) {
		queue = new int[size];
		queueSize = queue.length;
		rear = -1;
		front = -1;
	}
	
	public static void main(String[] args) {
		Queue queue = new Queue(5);
		queue.displayQueue();
		queue.insert(10);
		queue.insert(11);
		queue.insert(12);
		queue.insert(13);
		queue.insert(14);
		queue.delete();
		queue.insert(15);

	}
	
	public void delete() {
		if(front==-1) {
			System.out.println("Queue is already empty");
		}
		else {
			System.out.println(queue[front]+" is deleted from queue");
			for(int i = front; i<rear ; i++) {
				swap(i,i+1);
			}
			rear--;
			if(rear==-1) {
				front = -1;
			}
			displayQueue();
		}
	}
	
	public void insert(int ele) {
		if(rear+1>=queueSize) {
			System.out.println("Queue is already full");
		}
		else {
			rear++; 
			if(front==-1) {
				front++;
			}
			queue[rear] = ele;
			System.out.println(ele + " is added in queue");
			displayQueue();
		}
		
	}
	
	public void swap(int i , int j) {
		int temp = queue[i];
		queue[i] = queue[j];
		queue[j] = temp;				
	}
	
	
	public void displayQueue() {
		if(front == -1) {
			System.out.println("Queue is empty");
		}
		else {
		System.out.println("-----------------------------------------");	
		System.out.print("| ");
		
		
		 for(int i = front ; i <= queueSize-1; i++) {
			 if(i<=rear) {
				System.out.print(  queue[i] + " | ");
			 }
			 else {
				 System.out.print( "  "+ " | ");
			 }
			}
		System.out.println();
		 System.out.println("-----------------------------------------");	
		 System.out.print("| ");
		 for(int i = 0 ; i <queueSize ; i++) {
				System.out.print(  i + " |  ");
			}
		 System.out.println();
		 System.out.println("-----------------------------------------");
		}
	}
	


}
