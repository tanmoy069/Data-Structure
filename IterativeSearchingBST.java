package DataStructure;

/**
 * 
 * @author tanmoy.tushar
 * @since 01-07-2019
 */
public class IterativeSearchingBST {
	
	static Node root;
	
	class Node {
		int data;
		Node left, right;		
		Node(int value){
			data = value;
			left = right = null;
		}
	}
	
	boolean search(int value) {
		return iterativeSearch(root, value);
	}
	
	boolean iterativeSearch(Node node, int value) {
		while (node != null) {
			if (value > node.data) node = node.right;
			else if ( value < node.data) node = node.left;
			else return true;
		}
		return false;
	}
	
	void insert(int data) {
		root = insertValue(root, data);
	}
	
	Node insertValue(Node node, int value) {
		if(node == null) node = new Node(value);
		else if (value < node.data) node.left = insertValue(node.left, value);
		else if (value > node.data) node.right = insertValue(node.right, value);
		return node;
	}
	
	public static void main(String[] args) {
		IterativeSearchingBST tree = new IterativeSearchingBST();
		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);
		if(tree.search(40)) System.out.println("YES");
		else System.out.println("NO");
	}
}
