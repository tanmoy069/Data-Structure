package com.alvi.datastructure;

/**
 * Single Linked List Insertion and Deletion
 *  
 * @author tanmoy.tushar
 * @since 2019-10-11
 */
public class SingleLinkedListID {
	Node head;

	static class Node {
		int data;
		Node next;
		Node(int data) {
			this.data = data;
			next = null;
		}
	}

	/* Inserting a new node at the font of Linked List */
	private void push(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}

	/* Inserting a new node after a given node of Linked List */
	private void pushNext(Node preNode, int data) {
		if (preNode == null) {
			System.out.println("Previous node can't be NULL");
			return;
		}
		Node newNode = new Node(data);
		newNode.next = preNode.next;
		preNode.next = newNode;
	}

	/* Inserting a new node at the end of Linked List */
	private void append(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = new Node(data);
			return;
		}
		newNode.next = null;

		/* Searching for last node to set new node at the end */
		Node last = head;
		while (last.next != null) {
			last = last.next;
		}
		last.next = newNode;
		return;
	}

	private void deleteNodeByKey(int key) {
		Node temp = head, prev = null;

		// If head node itself holds the key to be deleted
		if (temp != null && temp.data == key) {
			head = temp.next;
			return;
		}

		/*
		 * Search for the key to be deleted, keep track of the 
		 * previous node as we need to change temp.next
		 */
		while (temp != null && temp.data != key) {
			prev = temp;
			temp = temp.next;
		}

		// If key was not present in linked list
		if (temp == null)
			return;

		// Unlink the node from linked list
		prev.next = temp.next;

	}

	private void deleteNodeByPosition(int position) {
		if (head == null) return;
		
		Node temp = head;
		
		if (position == 0) {
			head = temp.next;
			return;
		}

		// Find previous node of the node to be deleted
		for (int i = 0; temp != null && i < position - 1; i++) 
			temp = temp.next;

		// If position is more than number of ndoes
		if (temp == null || temp.next == null) return;

		/*
		 * Node temp->next is the node to be deleted
		 * Store pointer to the next of node to be deleted
		 */
		Node next = temp.next.next;

		temp.next = next; // Unlink the deleted node from list
	}
	
	/* Function deletes the entire linked list */
    private void deleteLinkedList() { 
        head = null;
        System.out.println("Linked List is deleted");
    } 

	private void printLinkedList() {
		if (head == null) {
			System.out.println("Linked List is empty");
			return;
		}
		Node node = head;
		while (node != null) {
			System.out.print(node.data + " "); // Printing data of node
			node = node.next; // Pointing node into next node
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		SingleLinkedListID linkedList = new SingleLinkedListID();
		linkedList.push(4);
		linkedList.push(3);
		linkedList.push(2);
		linkedList.push(1);
		linkedList.append(6);
		linkedList.append(8);
		linkedList.append(9);
		linkedList.append(10);
		linkedList.pushNext(linkedList.head.next.next.next, 5);
		linkedList.pushNext(linkedList.head.next.next.next.next.next, 7);
		linkedList.printLinkedList();
		
		linkedList.deleteNodeByKey(10);
		linkedList.printLinkedList();
		
		linkedList.append(10);
		linkedList.printLinkedList();
		
		linkedList.deleteNodeByPosition(4);
		linkedList.printLinkedList();
		
		linkedList.deleteLinkedList();
		linkedList.printLinkedList();
	}
}
