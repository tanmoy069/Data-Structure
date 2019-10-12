package com.alvi.datastructure;

/**
 * Data Structure of Single Linked List
 *  
 * @author tanmoy.tushar
 * @since 2019-10-11
 */
public class SingleLinkedList {	
	Node head;
	
	static class Node {
		int data;
		Node next;		
		Node(int data){
			this.data = data;
			next = null;
		}
	}
	
	private void printLinkedList() {
		Node node = head;
		while(node != null) {
			System.out.print(node.data + " "); // Printing data of node
			node = node.next; // Pointing node into next node
		}
	}
	
	public static void main(String[] args) {
		SingleLinkedList slList = new SingleLinkedList();
		
		/* Declaring nodes head value with parameter and next value's are default null */
		slList.head = new Node(1);
		Node secNode = new Node(2);
		Node thirdNode = new Node(3);
		
		/* Linking the Node next with next Node, By this all nodes are linked together */
		slList.head.next = secNode;
		secNode.next = thirdNode;
		
		slList.printLinkedList();		
	}
}
