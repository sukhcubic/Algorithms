

public class BinarySearchTree {

	class Node {
		int key;
		Node left, right;

		public Node(int item) {
			key = item;
			left = right = null;
		}
	}

	Node root;

	void insert(int val) {
		insertNode(root, val);
	};

	Node insertNode(Node root, int val) {
		if (root == null) {
			root = new Node(val);
			return root;
		}

		if (val > root.key) {
			root.right = insertNode(root.right, val);
		} else {
			root.left = insertNode(root.left, val);
		}
		return root;

	}
	
	public static void main(String args[]) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(5);
		bst.insert(4);
		bst.insert(6);
		bst.insert(8);
		bst.insert(9);
		bst.insert(2);
	}
}
