package DataStructure;

/**
 * 
 * @author tanmoy.tushar
 * @since 01-07-2019
 */
public class BinarySearchTree {
	
	class Node {
		int value;
		Node left, right;
		
		public Node(int item) {
			value = item;
			left = right = null;
		}
	}
	
	Node root;
	
	BinarySearchTree() {
		root = null;
	}
	
	void insert(int value) {
		root = insertValue(root, value);
	}
	
	void delete(int value) {
		root = deleteValue(root, value);
	}
	
	void inOrder() {
		inOrderRec(root);
	}
	
	void preOrder() {
		preOrderRec(root);
	}
	
	void postOrder() {
		postOrderRec(root);
	}
	
	Node insertValue(Node root, int value) {
		
		if(root == null) { 
			root = new Node(value);
			return root;
		}
		
		if(value < root.value) root.left = insertValue(root.left, value);
		
		else if(value > root.value) root.right = insertValue(root.right, value);
		
		return root;
	}
	
	Node deleteValue(Node root, int value) {
		
		if(root == null) return root;
		
		if(value < root.value) root.left = deleteValue(root.left, value);
		
		else if (value > root.value) root.right = deleteValue(root.right, value);
		
		else {
			
			if (root.left == null) return root.right;
			
			else if(root.right == null) return root.left;
			
			root.value = minValue(root.right);
			
			root.right = deleteValue(root.right, root.value);
		}
		
		return root;
	}
	
	int minValue (Node root) {		
		int min = root.value;		
		while (root.left !=  null) {
			min = root.left.value;
			root = root.left;
		}		
		return min;
	}
	
	void inOrderRec(Node root) {
		if(root != null) {
			inOrderRec(root.left);
			System.out.print(root.value + " ");
			inOrderRec(root.right);
		}
	}
	
	void preOrderRec(Node root) {
		if(root != null) {
			System.out.print(root.value + " ");
			inOrderRec(root.left);
			inOrderRec(root.right);
		}
	}
	
	void postOrderRec(Node root) {
		if(root != null) {
			inOrderRec(root.left);
			inOrderRec(root.right);
			System.out.print(root.value + " ");
		}
	}
	
	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		
		 /* Let us create following BST 
		        50
		      /    \ 
		    30      70 
		   /  \    /  \ 
		 20   40  60   80 */
		
		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);
		
		System.out.println("Showing inOrder traversal of BST");
		tree.inOrder();
		
		System.out.println("\nShowing preOrder traversal of BST");
		tree.preOrder();
				
		System.out.println("\nShowing postOrder traversal of BST");
		tree.postOrder();
		
		tree.delete(30);
		System.out.println("\nShowing inOrder traversal of BST after delete 30");
		tree.inOrder();
	}
}
