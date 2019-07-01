package DataStructure;

/**
 * 
 * @author tanmoy.tushar
 * @since 01-07-2019
 */
public class MinMaxValueInBST {
	
	class Node {
		int value;
		Node left, right;
		
		Node (int data){
			value = data;
			left = right = null;
		}
	}
	
	static Node root;
	
	void insert(int data) {
		root = insertValue(root, data);
	}
	
	Node insertValue (Node node, int data) {
		if(node == null) {
			node  = new Node(data);
			return node;
		}
		
		if(data < node.value) node.left = insertValue(node.left, data);
		
		else if (data > node.value) node.right = insertValue(node.right, data);
		return node;
	}
	
	int minValue (Node node) {
		Node current = node;
		
		while (current.left != null) {
			current = current.left;
		}
		return current.value;
	}
	
	int maxValue (Node node) {
		Node current = node;
		
		while (current.right != null) {
			current = current.right;
		}		
		return current.value;
	}
	
	public static void main(String[] args) {
		MinMaxValueInBST tree = new MinMaxValueInBST();
		tree.insert(4);
		tree.insert(2);
		tree.insert(1);
		tree.insert(3);
		tree.insert(6);
		tree.insert(5);
		
		System.out.println("Minimum value of BST is: " + tree.minValue(root));
		System.out.println("Maximum value of BST is: " + tree.maxValue(root));
		
	}

}
