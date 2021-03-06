package io.practise.ds.queue;

/*
 * A queue is a useful data structure in programming. It is similar to the ticket queue outside a cinema hall, 
 * where the first person entering the queue is the first person who gets the ticket.
 * Queue follows the First In First Out (FIFO) rule - the item that goes in first is the item that comes out first.
 * 
 * A queue is an object (an abstract data structure - ADT) that allows the following operations:

 * Enqueue: Add an element to the end of the queue
 * Dequeue: Remove an element from the front of the queue
 * IsEmpty: Check if the queue is empty
 * IsFull: Check if the queue is full
 * Peek: Get the value of the front of the queue without removing it
 */
public class Queue {

	int arr[];
	int front;
	int rear;
	int capacity;
	
	public Queue(int size) {
		arr = new int[size];
		front = -1;
		rear = -1;
		capacity = size;
	}
	
	public boolean isEmpty() {
		return front==-1 && rear == -1;
	}
	
	public boolean isFull() {
		return rear == capacity -1;
	}
	
	public void enqueue(int x) {
		if(isFull()) {
			System.out.println("Queue is full");
			return;
		}
		if(front ==-1) {
			++front;
		}
		arr[++rear] = x;
	}
	
	public void dequeue() {
		if(isEmpty()) {
			System.out.println("Queue is empty");
			return;
		}
		for(int i =front;i<rear;i++) {
			arr[i] = arr[i+1];
		}
		--rear;
		if(rear == -1) {
			front = -1;
		}
	}
	
	public void printQueue() {
		for(int i=0;i<=rear;i++) {
			System.out.println(arr[i]);
		}
	}
	
	public static void main(String[] args) {
		Queue q = new Queue(5);

	    q.enqueue(1);
	    q.enqueue(2);
	    q.enqueue(3);
	    q.enqueue(4);
	    q.enqueue(5);
	    
	    System.out.println("Before Dequeue");
	    q.printQueue();
	    q.dequeue();
	    System.out.println("After Dequeue");

	    q.printQueue();
	    q.enqueue(6);
	    System.out.println("After enqueue");
	    q.printQueue();

	}

}
