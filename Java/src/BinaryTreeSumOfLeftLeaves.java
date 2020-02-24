//https://leetcode.com/problems/sum-of-left-leaves/
//https://www.youtube.com/watch?v=_gnyuO2uquA
//https://www.youtube.com/watch?v=TzkfuLgpUxc
class BinaryTreeSumOfLeftLeaves{
// Todo: revisit again	
    public int sumOfLeftLeaves(TreeNode node) {
	if(node == null) {
			return 0;
		}
        
        if(node.left != null && node.left.left == null && node.left.right == null) {
		// explore right brancg as well and add value from right tree left leaf
			return node.left.val + sumOfLeftLeaves(node.right);
		}
		return sumOfLeftLeaves(node.left)+sumOfLeftLeaves(node.right);
    }



// 	public int sumOfLeaves(Node root) {
		
// 		return sumHelper(root, 0);
// 	}
	
// 	private int sumHelper(Node node, int sum) {

// 		if(node == null) {
// 			return sum;
// 		}

// 		if(node.left == null) {
// 			return node.key;
// 		}
	
// 		return sumHelper(node.left, sum + node.key) + sumHelper(node.right, sum + node.key);

// 	}

	public int sumOfLeaves(Node root) {
		
		return sumHelper(root);
	}
	
	
	    private int sumHelper(Node node) {

		if(node == null) {
			return 0;
		}

		if(node.left == null && node.right== null) {
			return node.key;
		}
	
		return sumHelper(node.left) + sumHelper(node.right);

	}
  

}
