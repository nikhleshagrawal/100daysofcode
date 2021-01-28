package io.practise.ds;

public class Stack {

	int arr[];
	int top;
	int capacity;
	
	public Stack(int size) {
		arr = new int[size];
		top = -1;
		capacity = size;
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public boolean isFull() {
		return top == capacity -1;
	}
	
	public void push(int x) {
		if(isFull()) {
			System.out.println("Stack is full");
			return;
		}
		
		arr[++top] = x;
	}
	
	public void pop() {
		if(isEmpty()) {
			System.out.println("Stack is empty");
			return;
		}
		
		--top;
	}
	
	public void printStack() {
		for(int i=top;i>=0;i--) {
			System.out.println(arr[i]);
		}
	}
	
	public static void main(String[] args) {
		Stack stack = new Stack(5);

	    stack.push(1);
	    stack.push(2);
	    stack.push(3);
	    stack.push(4);
	    System.out.println("\nBefore popping out");
	    stack.printStack();
	    stack.pop();
	    System.out.println("\nAfter popping out");

	    stack.printStack();

	}

}
