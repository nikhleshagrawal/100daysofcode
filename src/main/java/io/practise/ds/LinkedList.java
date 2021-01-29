package io.practise.ds;

public class LinkedList {

	// use to point to head of the list
	Node head;

	static class Node {
		int data;
		// point to next in the list
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	public LinkedList insert(LinkedList list, int data) {

		Node n = new Node(data);
		System.out.println("Inserting " + data);
		if (list.head == null) {
			list.head = n;
		} else {
			Node last = list.head;
			while (last.next != null) {
				last = last.next;
			}
			last.next = n;
		}

		return list;
	}

	public Node search(LinkedList list, int data) {
		Node last = list.head;
		while (last != null) {
			if(last.data == data) {
				return last;
			}
			last = last.next;
		}

		return null;
	}
	
	public LinkedList remove(LinkedList list, int data) {
		Node last = list.head;
		Node prev = list.head;
		if(list.head.data == data) {
			System.out.println("Removing " + data);
			list.head = list.head.next;
			return list;
		}
		while (last != null) {
			if(last.data == data) {
				System.out.println("Removing " + data);
				prev.next = last.next;
				break; 
			}
			prev = last;
			last = last.next;
		}
		System.out.println("Not found " + data);
		return list;
	}

	public void displayList(LinkedList list) {
		Node last = list.head;
		while (last != null) {
			System.out.println(last.data);
			last = last.next;
		}
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list = list.insert(list, 1);
		//list = list.insert(list, 2);
		//list = list.insert(list, 3);
		//list = list.insert(list, 4);
		//list = list.insert(list, 5);

		list.displayList(list);
		
		list.remove(list, 2);
		list.displayList(list);

	}

}
