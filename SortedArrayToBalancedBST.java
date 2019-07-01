package DataStructure;

/**
 * 
 * @author tanmoy.tushar
 * @since 01-07-2019
 *
 */
public class SortedArrayToBalancedBST {
	
	class Node {		
		int value;
		Node left, right;
		
		Node (int data){
			value = data;
			left = right = null;
		}
	}
	
	static Node root;
	
	Node sortedArrayToBST(int arr[], int start, int end) {
		if (start > end) return null;
		
		int mid = (start + end) / 2;
		Node node = new Node(arr[mid]);
		
		node.left = sortedArrayToBST(arr, start, mid - 1);
		node.right = sortedArrayToBST(arr, mid + 1, end);
		
		return node;
	}
	
	void preOrder(Node node) {
		if (node != null) {
			System.out.print(node.value + " ");
			preOrder(node.left);
			preOrder(node.right);
		}
	}
	
	public static void main(String[] args) {
		SortedArrayToBalancedBST tree = new SortedArrayToBalancedBST();
		int arr[] = new int[] {1, 2, 3, 4, 5, 6, 7, 8};
		int n = arr.length;
		root = tree.sortedArrayToBST(arr, 0, n - 1);
		System.out.println("PreOrder traversal of constructed BST");
		tree.preOrder(root);
	}
}
