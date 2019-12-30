

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
	       root = insertNode(root, val);
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

	void printAll(Node root) {
		if (root != null) {
			printAll(root.left);
			System.out.println(root.key);
			printAll(root.right);
		}
	}

	public static void main(String args[]) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(5);
		bst.insert(4);
		bst.insert(6);
		bst.insert(8);
		bst.insert(9);
		bst.insert(2);

		bst.printAll(bst.root);
	}
}
