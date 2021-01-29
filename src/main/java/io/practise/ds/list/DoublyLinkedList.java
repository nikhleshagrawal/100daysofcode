package io.practise.ds.list;

/*
 * We add a pointer to the previous node in a doubly-linked list. 
 * Thus, we can go in either direction: forward or backward.
 */
public class DoublyLinkedList {

	// use to point to head of the list
	Node head;

	class Node {
		int data;
		// point to next in the list
		Node next;
		Node prev;

		Node(int data) {
			this.data = data;
		}
	}

	public DoublyLinkedList insert(DoublyLinkedList list, int data) {

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
			n.prev= last;
		}

		return list;
	}

	public Node search(DoublyLinkedList list, int data) {
		Node last = list.head;
		while (last != null) {
			if(last.data == data) {
				return last;
			}
			last = last.next;
		}

		return null;
	}
	
	public DoublyLinkedList remove(DoublyLinkedList list, int data) {
		
		if(list.head.data == data) {
			System.out.println("Removing " + data);
			list.head = list.head.next;
			return list;
		}
		
		Node last = list.head.next;
		boolean found = false;
		while (last != null) {
			if(last.data == data) {
				System.out.println("Removing " + data);
				found  =true;
				last.prev.next = last.next;
				if(last.next!=null) {
					last.next.prev = last.prev;	
				}
				
				break; 
			}
			last = last.next;
		}
		if(!found) {
			System.out.println("Not found " + data);	
		}
		return list;
	}

	public void displayList(DoublyLinkedList list) {
		Node last = list.head;
		while (last != null) {
			System.out.println(last.data);
			last = last.next;
		}
	}

	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();
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
