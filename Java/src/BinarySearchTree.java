

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
}
