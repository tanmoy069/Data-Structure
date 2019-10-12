package com.alvi.datastructure;

/**
 * Data Structure of Circular Linked List
 * 
 * @author tanmoy.tushar
 * @since 2019-10-11
 */
public class CircularLinkedList {
	
	// Declaring static to skip declaring it from each function
	static Node head;

	static class Node {
		int data;
		Node next;
	}

	/**
	 * Function for inserting a new node at the font of list
	 * 
	 * @param refNode {@link set reference node}
	 * @param data {@link set Integer type}
	 * @return {@link return new Node}
	 */
	private Node push(Node refNode, int data) {
		Node newNode = new Node();
		Node temp = refNode;
		newNode.data = data;
		newNode.next = refNode;

		//If linked list is not null then set the next of last node
		if (refNode != null) {
			while (temp.next != refNode)
				temp = temp.next;
			temp.next = newNode;
		} else newNode.next = newNode;

		return newNode;
	}

	// Function for printing Circular list
	private void print() {
		Node temp = head;
		if (head != null) {
			do {
				System.out.print(temp.data + " ");
				temp = temp.next;
			} while (temp != head);
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		CircularLinkedList crList = new CircularLinkedList();
		head = crList.push(head, 1);
		head = crList.push(head, 3);
		head = crList.push(head, 2);
		head = crList.push(head, 4);
		head = crList.push(head, 6);
		head = crList.push(head, 5);
		crList.print();
	}

}
