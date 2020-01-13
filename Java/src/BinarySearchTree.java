

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
	

	int floor(Node x, int value){
		if (x == null) {
			return -1;
		}
		
		if(x.key == value) {
			return x.key;
		}
		
		if(x.key < value) {
			
			return floor(x.right, value);
			
		}
		
		int flr = floor(x.left, value);
		
		return (flr >= value) ? flr: x.key;
	}


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
	
	boolean find(Node root, int val) {
		if (root != null) {
			if (root.key == val) {
				return true;
			} else if (val > root.key) {
				find(root.right, val);
			} else {
				find(root.left, val);
			}
		}
		return false;
	}
	
	public static void main(String args[]) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(5);
		bst.insert(4);
		bst.insert(6);
		bst.insert(2);
		//bst.printAll(bst.root);
		//System.out.print(bst.find(bst.root, 5));
		System.out.print(bst.floor(bst.root, 7));
	}
}
