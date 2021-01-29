package io.practise.ds;

public class DeQueue {

	int arr[];
	int front;
	int rear;
	int capacity;

	public DeQueue(int size) {
		arr = new int[size];
		front = -1;
		rear = -1;
		capacity = size;
	}

	public boolean isEmpty() {
		return front == rear;
	}

	public boolean isFull() {
		return (rear == capacity - 1 && front == 0) || (rear == front - 1);
	}

	public void enqueueRear(int x) {

		if (isFull()) {
			System.out.println("Queue is full");
			return;
		}
		System.out.println("enqueue Rear " + x);
		if (front == -1) {
			++front;
		}
		if ((rear == capacity - 1) && front != 0) {
			rear = -1;
			arr[++rear] = x;
		} else {
			arr[++rear] = x;
		}

	}
	
	public void enqueueFront(int x) {

		if (isFull()) {
			System.out.println("Queue is full");
			return;
		}
		System.out.println("enqueue Front " + x);
		if (front == -1) {
			++front;
		}
		if (front <1 ) {
			front = capacity -1;
			
		} else {
			front = front  -1;
		}
		arr[front] = x;

	}

	public void dequeueFront() {
		if (isEmpty()) {
			front = -1;
			rear=-1;
			System.out.println("Queue is empty");
			return;
		}
		System.out.println("dequeue Front " + arr[front]);
		if (front == capacity - 1) {
			front = 0;
		} else {

			front++;
		
		
		}
	}
	
	public void dequeueRear() {
		if (isEmpty()) {
			front = -1;
			rear=-1;
			System.out.println("Queue is empty");
			return;
		}
		System.out.println("dequeue Rear " + arr[rear]);
		if (rear == 0) {
			rear = capacity -1;
		} else {

			rear--;
		}
	}

	public void printQueue() {

		int i = front;
		while (i != rear) {
			System.out.println(arr[i]);
			if (i == capacity - 1) {
				i = 0;
			} else {
				i++;
			}
		}
		System.out.println(arr[i]);

	}

	public static void main(String[] args) {
		DeQueue dq = new DeQueue(4);
	    dq.enqueueRear(12);
	    System.out.println("After enqueueRear ");
	    dq.printQueue();
	    dq.enqueueRear(14);
	    System.out.println("After enqueueRear ");
	    dq.printQueue();
	    dq.dequeueRear();;
	    System.out.println("After dequeueRear ");
	    dq.printQueue();
	    dq.enqueueFront(13);
	    System.out.println("After enqueueFront ");
	    dq.printQueue();
	    dq.dequeueFront();
	    System.out.println("After dequeueFront ");
	    dq.printQueue();
	    
	}

}
