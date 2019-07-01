package DataStructure;

import java.util.Scanner;

public class DistanceOfTwoNode {

	static Node root;

	class Node {
		int data;
		Node left, right;
		Node(int value) {
			data = value;
			left = right = null;
		}
	}

	void insert(int data) {
		root = insertValue(root, data);
	}	

	Node insertValue(Node node, int data) {
		if (node == null)
			node = new Node(data);
		else if (data < node.data)
			node.left = insertValue(node.left, data);
		else if (data > node.data)
			node.right = insertValue(node.right, data);
		return node;
	}
	
	void inOrder(Node node) {
		if(node != null) {
			System.out.print(node.data + " ");
			inOrder(node.left);
			inOrder(node.right);
		}
	}

	int distanceFromRoot(Node node, int x) {
		if (node.data == x)
			return 0;
		else if (node.data > x)
			return 1 + distanceFromRoot(node.left, x);
		return 1 + distanceFromRoot(node.right, x);
	}

	int distanceBetweenNode(Node node, int a, int b) {
		if (node == null)
			return 0;
		if (node.data > a && node.data > b)
			return distanceBetweenNode(node.left, a, b);
		if (node.data < a && node.data < b)
			return distanceBetweenNode(node.right, a, b);
		if (node.data >= a && node.data <= b)
			return distanceFromRoot(node, a) + distanceFromRoot(node, b);
		return 0;
	}

	int findDistanceWrapper(Node node, int a, int b) {
		int temp = 0;
		if (a > b) {
			temp = a;
			a = b;
			b = temp;
		}
		return distanceBetweenNode(node, a, b);
	}
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		DistanceOfTwoNode tree = new DistanceOfTwoNode();
		tree.insert(20);
		tree.insert(10);
		tree.insert(5);
		tree.insert(15);
		tree.insert(30);
		tree.insert(25);
		tree.insert(35);
		tree.inOrder(root);

		int a, b;
		System.out.println("\nChoose two node to find distance");	
		a = sc.nextInt();
		b = sc.nextInt();
			
		System.out.println("Distance between " + a + " & " + b + " is: " + tree.findDistanceWrapper(root, a, b));
	}

}
