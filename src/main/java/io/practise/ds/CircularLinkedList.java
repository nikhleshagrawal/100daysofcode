package io.practise.ds;

/*
 * A circular linked list is a variation of a linked list in which the last element is linked to the first element. 
 * This forms a circular loop.
 */
public class CircularLinkedList {

	// use to point to head of the list
	Node head;

	class Node {
		int data;
		// point to next in the list
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	public CircularLinkedList insert(CircularLinkedList list, int data) {

		Node n = new Node(data);
		System.out.println("Inserting " + data);
		if (list.head == null) {
			list.head = n;
			n.next = head;
		} else {
			Node last = list.head;
			while (last.next != head) {
				last = last.next;
			}
			last.next = n;
			n.next = head;
		}

		return list;
	}

	public Node search(CircularLinkedList list, int data) {
		Node last = list.head;
		while (last != head) {
			if(last.data == data) {
				return last;
			}
			last = last.next;
		}

		return null;
	}
	
	public CircularLinkedList remove(CircularLinkedList list, int data) {
		
		if(list.head.data == data) {
			System.out.println("Removing " + data);
			list.head = list.head.next;
			return list;
		}
		
		Node last = list.head.next;
		Node prev = list.head;
		boolean found = false;
		while (last != head) {
			if(last.data == data) {
				System.out.println("Removing " + data);
				prev.next = last.next;
				found  =true;
				break; 
			}
			prev = last;
			last = last.next;
		}
		if(!found) {
			System.out.println("Not found " + data);	
		}
		
		return list;
	}

	public void displayList(CircularLinkedList list) {
		Node last = list.head;
		while (last.next != head) {
			System.out.println(last.data);
			last = last.next;
		}
		System.out.println(last.data);
	}

	public static void main(String[] args) {
		CircularLinkedList list = new CircularLinkedList();
		list = list.insert(list, 1);
		list = list.insert(list, 2);
		list = list.insert(list, 3);
		list = list.insert(list, 4);
		list = list.insert(list, 5);

		list.displayList(list);
		
		list.remove(list, 2);
		list.displayList(list);

	}

}
