//https://leetcode.com/problems/sum-of-left-leaves/
//https://www.youtube.com/watch?v=_gnyuO2uquA
//https://www.youtube.com/watch?v=TzkfuLgpUxc
class BinaryTreeSumOfLeftLeaves{
	
	public int sumOfLeftLeaves(){
	
	  return leftLeaveHelper();
	}
	
	private int leftLeaveHelper(Node node, int sum) {

		// return 0 
		if(node == null) {
			return 0;
		}

		if(node.left == null) {
			return node.key;
		}
	
		return leftLeaveHelper(node.left, sum + node.key) + leftLeaveHelper(node.right, sum + node.key);

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
