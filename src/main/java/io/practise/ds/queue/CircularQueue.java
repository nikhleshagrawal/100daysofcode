package io.practise.ds.queue;

/*
 * In a circular queue, the last element points to the first element making a circular link.
 * The main advantage of a circular queue over a simple queue is better memory utilization. 
 * If the last position is full and the first position is empty, we can insert an element in the first position. 
 * This action is not possible in a simple queue.
 */
public class CircularQueue {

	int arr[];
	int front;
	int rear;
	int capacity;

	public CircularQueue(int size) {
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

	public void enqueue(int x) {

		if (isFull()) {
			System.out.println("Queue is full");
			return;
		}
		System.out.println("enqueue " + x);
		if (front == -1) {
			++front;
		}
		if ((rear == capacity - 1) && front != 0) {
			rear = -1;
		} 
		arr[++rear] = x;
	}

	public void dequeue() {
		if (isEmpty()) {
			front = -1;
			rear=-1;
			System.out.println("Queue is empty");
			return;
		}
		System.out.println("dequeue " + arr[front]);
		if (front == capacity - 1) {
			front = 0;
		} else {

			front++;
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
		CircularQueue q = new CircularQueue(5);

		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);
		q.enqueue(6);
		System.out.println("Before Dequeue");
		q.printQueue();
		q.dequeue();
		System.out.println("After Dequeue");

		q.printQueue();
		q.enqueue(6);
		System.out.println("After Enqueue");
		q.printQueue();
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.enqueue(6);
		System.out.println("After Enqueue");

		q.printQueue();
	}

}
