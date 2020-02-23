class BinaryTreeSumOfLeftLeaves{

	public int sumOfLeaves(Node root) {
		
		return sumHelper(root, 0);
	}
	
	private int sumHelper(Node node, int sum) {

		if(node == null) {
			return sum;
		}

		if(node.left == null) {
			return node.key;
		}
	
		return sumHelper(node.left, sum + node.key) + sumHelper(node.right, sum + node.key);

	}


}
