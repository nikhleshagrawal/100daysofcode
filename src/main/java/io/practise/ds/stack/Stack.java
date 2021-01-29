package io.practise.ds.stack;

/*
 * A stack is a useful data structure in programming. It is just like a pile of plates kept on top of each other.
 * LIFO Principle of Stack
 * In programming terms, putting an item on top of the stack is called push and removing an item is called pop.
 * A stack is an object (an abstract data type - ADT) that allows the following operations:

 * Push: Add an element to the top of a stack
 * Pop: Remove an element from the top of a stack
 * IsEmpty: Check if the stack is empty
 * IsFull: Check if the stack is full
 * Peek: Get the value of the top element without removing it
 * 
 */
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
